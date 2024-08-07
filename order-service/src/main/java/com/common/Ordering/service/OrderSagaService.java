package com.common.Ordering.service;

import com.common.Ordering.entity.Order;
import com.common.Ordering.enums.OrderStatus;
import com.common.Ordering.model.OrderCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderSagaService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private OrderService orderProcessingSaga;

    @JmsListener(destination = "saga.order", containerFactory = "jmsListenerContainerFactory")
    public void processOrder(OrderCreateEvent orderCreateEvent) {
        OrderStatus status = orderCreateEvent.getOrderStatus();
        if(status.equals(OrderStatus.INITIATED)){
            jmsTemplate.convertAndSend("saga.reserve", orderCreateEvent);
        }else if(status.equals(OrderStatus.RESERVED)){
            jmsTemplate.convertAndSend("saga.charge", orderCreateEvent);
        }else if(status.equals(OrderStatus.CHARGED)){
            jmsTemplate.convertAndSend("saga.schedule", orderCreateEvent);
        }else if(status.equals(OrderStatus.SHIPPED)){
            jmsTemplate.convertAndSend("saga.completed", orderCreateEvent);
        }
    }

    @JmsListener(destination = "saga.failed", containerFactory = "jmsListenerContainerFactory")
    public void rollbackOrder(OrderCreateEvent orderCreateEvent){

    }

    @JmsListener(destination = "saga.completed", containerFactory = "jmsListenerContainerFactory")
    public void orderCompleted(OrderCreateEvent orderCreateEvent){
      // we can here set flag in DB to mark that the order is already done..
    }
}
