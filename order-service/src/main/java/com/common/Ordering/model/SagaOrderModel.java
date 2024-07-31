package com.common.Ordering.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SagaOrderModel {
    private String orderId;
    private List<ProductModel> products;
    private Double Price;
    private String customerId;

    private Boolean paymentSucceeded = false;
    private Boolean shipmentScheduled = false;
    private Boolean inventoryReserved = false;
}