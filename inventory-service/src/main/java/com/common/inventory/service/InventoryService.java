package com.common.inventory.service;

import com.common.inventory.clients.StudentDetailsWebClient;
import com.common.inventory.model.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

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
