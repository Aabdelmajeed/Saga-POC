package com.common.Ordering.clients;

import com.common.Ordering.model.SagaOrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

//TODO webClient
@Repository
public class StudentDetailsWebClient {

    @Autowired
    WebClient webClient;

    public Mono<List<SagaOrderModel>> getStudentDetailsUsingWebClient() {
        return this.webClient.get()
                .uri("/students")
                .retrieve()
                .bodyToFlux(SagaOrderModel.class)
                .collectList();
    }
}
