package com.common.Ordering.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class PaymentClient {
    private final WebClient paymentWebClient;

    @Autowired
    public PaymentClient( WebClient paymentWebClient) {
         this.paymentWebClient = paymentWebClient;
    }

    public void refundUser(String orderId){

    }
}
