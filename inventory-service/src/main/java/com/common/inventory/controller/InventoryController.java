package com.common.inventory.controller;

import com.common.inventory.model.StudentDetails;
import com.common.inventory.model.response.ApiResponseModel;
import com.common.inventory.repository.ProductRepository;
import com.common.inventory.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.websocket.server.PathParam;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class InventoryController {

    InventoryService inventoryService;

    ProductRepository productRepository;

    @GetMapping(path = "/release/{id}")
    @Operation(summary = "release product id after reserved", description = "release product id after reserved")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully released product id after reserved"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ApiResponseModel<Boolean>> releaseProduct(@PathParam("id") String productId){
        Boolean status= inventoryService.releaseProduct(productId);
        ApiResponseModel<Boolean> response = new ApiResponseModel<>();
        response.setData(status);
        response.setStatus("success");

        return ResponseEntity.ok(response);
     }
}
