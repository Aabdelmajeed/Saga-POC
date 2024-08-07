package com.common.Ordering.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class InventoryClient {

    private final WebClient inventoryWebClient;

    @Autowired
    public InventoryClient(WebClient inventoryWebClient) {
         this.inventoryWebClient = inventoryWebClient;
    }



    public void unReserverOrder(String orderId) {

        inventoryWebClient.get()
                .uri(uriBuilder -> uriBuilder.path("/unreserve/{orderId}")
                        .build(orderId))
                .retrieve()
                .bodyToMono(Void.class)
                .block();

    }
}
