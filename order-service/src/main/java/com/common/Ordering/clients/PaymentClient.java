package com.common.Ordering.clients;

import com.common.Ordering.model.SagaOrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class PaymentClient {
    private final WebClient paymentWebClient;
    private final SagaOrderModel orderModel;

    @Autowired
    public PaymentClient(SagaOrderModel orderModel, WebClient paymentWebClient) {
        this.orderModel = orderModel;
        this.paymentWebClient = paymentWebClient;
    }

    public void refundUser(String orderId){

    }
}
