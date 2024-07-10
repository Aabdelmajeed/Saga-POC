package com.common.ReliSol.service;

import com.common.ReliSol.clients.StudentDetailsWebClient;
import com.common.ReliSol.model.StudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelisolService {

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
