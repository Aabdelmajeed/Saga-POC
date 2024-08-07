package com.common.shipping.service;

import com.common.shipping.enums.OrderStatus;
import com.common.shipping.model.OrderCreateEvent;
import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {

    private JmsTemplate jmsTemplate;


    @JmsListener(destination = "saga.charge", containerFactory = "jmsListenerContainerFactory")
    public void chargeOrder(OrderCreateEvent orderCreateEvent){
        // considering the charge is successed
        boolean chargeStatus = true;
        if(chargeStatus){
            orderCreateEvent.setOrderStatus(OrderStatus.CHARGED);
            jmsTemplate.convertAndSend("saga.order", orderCreateEvent);
        }else{
            jmsTemplate.convertAndSend("saga.failed", orderCreateEvent);
        }
    }


    public boolean refundUser(Long userId, Double chargeValue) {
        // Here you call 3rd party to refund user by chargeValue.
        return true;
    }
}
