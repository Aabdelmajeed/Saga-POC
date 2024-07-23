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
public class ShippingService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "shipping.schedule", containerFactory = "jmsListenerContainerFactory")
    public void scheduleShipment(String message) {
        // Schedule the shipment of the product
        // Send a message back to the saga to indicate success or failure
        jmsTemplate.convertAndSend("saga.order", "shipment.scheduled");
    }
}
