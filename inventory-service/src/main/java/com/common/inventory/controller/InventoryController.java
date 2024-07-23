package com.common.inventory.controller;

import com.common.inventory.model.StudentDetails;
import com.common.inventory.model.response.ApiResponseModel;
import com.common.inventory.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relisol1")
public class InventoryController {

    @Autowired
    InventoryService relisolService;
//    @GetMapping
//    @Operation(summary = "Relisol1 dummy controller", description = "relisol1 dummy controller.")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Successfully Invoked relisol controller 1"),
//            @ApiResponse(responseCode = "500", description = "Internal server error")
//    })
//    public ResponseEntity<ApiResponseModel<String>> reliso1DummyAPI(){
//        ApiResponseModel<String> response = new ApiResponseModel<>();
//        String res = relisolService.getServiceValue();
//        response.setData(res);
//        response.setStatus("success");
//        return ResponseEntity.ok(response);
//    }
//    //TODO webClient
//    @GetMapping(path = "/webclient")
//    @Operation(summary = "using WebClient to get StudentDetails", description = "Get studentDetails using webclient")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Successfully Invoked relisol controller 1"),
//            @ApiResponse(responseCode = "500", description = "Internal server error")
//    })
//    public ResponseEntity<ApiResponseModel<List<StudentDetails>>> webClientStudentDetails(){
//        ApiResponseModel<List<StudentDetails>> response = new ApiResponseModel<>();
//        List<StudentDetails> studentDetailsList = relisolService.getStudentDetailsUsingWebClient();
//        response.setData(studentDetailsList);
//        response.setStatus("success");
//        return ResponseEntity.ok(response);
//    }
}
