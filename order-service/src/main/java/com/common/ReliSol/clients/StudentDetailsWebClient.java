package com.common.ReliSol.clients;

import com.common.ReliSol.model.StudentDetails;
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

    public Mono<List<StudentDetails>> getStudentDetailsUsingWebClient(){
         return this.webClient.get()
                 .uri("/students")
                 .retrieve()
                 .bodyToFlux(StudentDetails.class)
                 .collectList();
    }
}
