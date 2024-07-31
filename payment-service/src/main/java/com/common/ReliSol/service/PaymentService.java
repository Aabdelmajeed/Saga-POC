package com.common.ReliSol.service;

import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {

    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "payment.charge", containerFactory = "jmsListenerContainerFactory")
    public void chargePayment(String message) {
        // Charge the customer's payment method
        // Send a message back to the saga to indicate success or failure
        jmsTemplate.convertAndSend("saga.order", "payment.charged");
    }


    public boolean refundUser(Long userId, Double chargeValue){
          // Here you call 3rd party to refund user by chargeValue.
        return true;
    }
}
