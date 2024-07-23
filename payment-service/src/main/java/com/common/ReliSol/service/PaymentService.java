package com.common.ReliSol.service;

import com.common.ReliSol.clients.StudentDetailsWebClient;
import com.common.ReliSol.model.StudentDetails;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
