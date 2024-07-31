package com.common.Ordering.clients;

import com.common.Ordering.model.SagaOrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class InventoryClient {

    private final WebClient inventoryWebClient;
    private final SagaOrderModel orderModel;

    @Autowired
    public InventoryClient(SagaOrderModel orderModel, WebClient inventoryWebClient) {
        this.orderModel = orderModel;
        this.inventoryWebClient = inventoryWebClient;
    }

    public void reserveOrder() {
        String orderId = orderModel.getOrderId();
        inventoryWebClient.get()
                .uri(uriBuilder -> uriBuilder.path("/reserve/{orderId}")
                        .build(orderId))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public void unReserverOrder() {
        String orderId = orderModel.getOrderId();

        inventoryWebClient.get()
                .uri(uriBuilder -> uriBuilder.path("/unreserve/{orderId}")
                        .build(orderId))
                .retrieve()
                .bodyToMono(Void.class)
                .block();

    }
}
