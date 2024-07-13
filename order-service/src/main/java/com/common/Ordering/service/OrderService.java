package com.common.Ordering.service;

import com.common.Ordering.clients.StudentDetailsWebClient;
import com.common.Ordering.model.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    StudentDetailsWebClient studentDetailsWebClient;

    public String getServiceValue(){
        return "Relisol Service Response.";
    }

    //TODO webClient
    public List<StudentDetails> getStudentDetailsUsingWebClient(){
        return studentDetailsWebClient.getStudentDetailsUsingWebClient().block();
    }
}
