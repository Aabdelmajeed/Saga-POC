package com.common.payment.controller;

import com.common.payment.model.response.ApiResponseModel;
import com.common.payment.service.jms.JmsProducer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//TODO jms
@RestController
@RequestMapping("/jms")
public class JmsController {
    @Autowired
    private JmsProducer jmsProducer;

    @GetMapping
    @Operation(summary = "jms poc", description = "jms dummy controller.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Invoked relisol controller 1"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ApiResponseModel<String>> reliso1DummyAPI(@RequestParam("jmsMsg") String jmsMsg){
        jmsProducer.sendMessage(jmsMsg);

        ApiResponseModel<String> response = new ApiResponseModel<>();
        response.setStatus("success");
        return ResponseEntity.ok(response);
    }
}
