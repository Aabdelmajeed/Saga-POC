package com.common.Ordering.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
//TODO webClient
@Configuration
public class WebClientConfig {


    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl("http://localhost:3000")
                .build();

    }

    @Bean
    public WebClient inventoryWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl("http://localhost:8083")
                .build();
    }

    @Bean
    public WebClient paymentWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl("http://localhost:9090")
                .build();
    }

    @Bean
    public WebClient shippingWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl("http://localhost:8085")
                .build();
    }


}
