package com.common.inventory.service;

import com.common.inventory.clients.StudentDetailsWebClient;
import com.common.inventory.model.StudentDetails;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryService {


    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "inventory.reserve", containerFactory = "jmsListenerContainerFactory")
    public void reserveInventory(String message) {
        // Reserve the inventory for the product
        // Send a message back to the saga to indicate success or failure
        jmsTemplate.convertAndSend("saga.order", "inventory.reserved");
    }
}
