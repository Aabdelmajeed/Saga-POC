package com.common.Ordering.service;

import com.common.Ordering.model.SagaOrderModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderService {
    SagaOrderModel sagaOrder;

    public void processOrder() {
        reserveInventory();
    }

    public void reserveInventory() {
        // Send message to the Inventory Service to reserve the product
        // Set inventoryReserved to true if the reservation succeeds
    }

    public void chargePayment() {
        // Send message to the Payment Service to charge the customer
        // Set paymentSucceeded to true if the payment succeeds
    }

    public void scheduleShipment() {
        // Send message to the Shipping Service to schedule the shipment
        // Set shipmentScheduled to true if the shipment is scheduled successfully
    }

    public void cancelOrder() {
        // Roll back all previous transactions
    }
}
