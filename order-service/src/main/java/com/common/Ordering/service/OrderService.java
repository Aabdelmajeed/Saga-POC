package com.common.Ordering.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private OrderProcessingSagaService orderProcessingSaga;

    @JmsListener(destination = "saga.order", containerFactory = "jmsListenerContainerFactory")
    public void processOrder(String message) {
        // Handle messages from the services
        if (message.equals("inventory.reserved")) {
            orderProcessingSaga.setInventoryReserved(true);
            orderProcessingSaga.chargePayment();
        } else if (message.equals("payment.charged")) {
            orderProcessingSaga.setPaymentSucceeded(true);
            orderProcessingSaga.scheduleShipment();
        } else if (message.equals("shipment.scheduled")) {
            orderProcessingSaga.setShipmentScheduled(true);
        }

        // Handle failure scenarios
        if (!orderProcessingSaga.getInventoryReserved()) {
            orderProcessingSaga.cancelOrder();
            jmsTemplate.convertAndSend("order.failed", "Inventory not reserved");
        } else if (!orderProcessingSaga.getPaymentSucceeded()) {
            orderProcessingSaga.cancelOrder();
            jmsTemplate.convertAndSend("order.failed", "Payment not charged");
        } else if (!orderProcessingSaga.getShipmentScheduled()) {
            orderProcessingSaga.cancelOrder();
            jmsTemplate.convertAndSend("order.failed", "Shipment not scheduled");
        } else {
            jmsTemplate.convertAndSend("order.completed", "Order processed successfully");
        }
    }
}
