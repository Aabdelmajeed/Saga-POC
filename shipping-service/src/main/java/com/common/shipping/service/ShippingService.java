package com.common.shipping.service;

import com.common.shipping.enums.OrderStatus;
import com.common.shipping.model.OrderCreateEvent;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShippingService {

    @Autowired
    private JmsTemplate jmsTemplate;


    @JmsListener(destination = "saga.schedule", containerFactory = "jmsListenerContainerFactory")
    public void shipOrder(OrderCreateEvent orderCreateEvent) {
        // do all logic to schedule the order id defined in orderCreateEvent.orderId and change the status
        // by default we set it true considering the shippment successed.
        boolean orderStatus = true;
        if(orderStatus){
            orderCreateEvent.setOrderStatus(OrderStatus.COMPLETED);
            jmsTemplate.convertAndSend("saga.order", orderCreateEvent);

        }else{
            jmsTemplate.convertAndSend("saga.failed", orderCreateEvent);

        }
    }

}
