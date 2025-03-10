package com.common.Ordering.model.response;

import lombok.Data;

@Data
public class ApiResponseModel<T> {
    private String status;
    private String result;
    private ErrorResponse error;
    private T data;
}