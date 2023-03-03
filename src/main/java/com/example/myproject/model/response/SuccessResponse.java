package com.example.myproject.model.response;

import lombok.Data;

@Data
public class SuccessResponse<T> extends CommonResponse {
    T data;

    public SuccessResponse(String code, String status, String message, T data) {
        super.setCode(code);
        super.setStatus(status);
        super.setMessage(message);
        this.data = data;
    }
}
