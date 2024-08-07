package com.common.Ordering.service;

import com.common.Ordering.clients.InventoryClient;
import com.common.Ordering.clients.PaymentClient;
import com.common.Ordering.model.OrderCreateEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderService {
    InventoryClient inventoryClient;
    PaymentClient paymentClient;

    @Autowired
    private JmsTemplate jmsTemplate;

    // SEND TO ORDER TOPIC
    public void processOrder(String orderId) {
        OrderCreateEvent orderCreateEvent = new OrderCreateEvent(orderId);
        jmsTemplate.convertAndSend("saga.order", orderCreateEvent);
    }

    public void cancelOrder(String orderId) {
        // Roll back all previous transactions
        inventoryClient.unReserverOrder(orderId);
        paymentClient.refundUser(orderId);
     }
}
