package com.common.ReliSol.controller;

import com.common.ReliSol.model.response.ApiResponseModel;
import com.common.ReliSol.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }


    @GetMapping(value = "/refund")
    @Operation(summary = "refund user", description = "refund user by given amount")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Invoked relisol controller 1"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ApiResponseModel<Boolean>> refundUser(@PathParam("userId") Long userId , @PathParam("refundAmount") Double refundAmount){
        ApiResponseModel<Boolean> response = new ApiResponseModel<>();
        Boolean refundUser = paymentService.refundUser(userId , refundAmount);
        response.setData(refundUser);
        response.setStatus("success");
        return ResponseEntity.ok(response);
    }
}
