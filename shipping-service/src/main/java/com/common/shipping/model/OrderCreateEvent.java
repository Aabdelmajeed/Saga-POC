package com.common.shipping.model;

import com.common.shipping.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderCreateEvent {
    private String orderId;
    private OrderStatus orderStatus;
    private Double totalSalary;

    public OrderCreateEvent(String orderId){
        this.orderId = orderId;
        this.orderStatus = OrderStatus.INITIATED;
    }
}
