package com.example.myproject.exception;

import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@Getter
public class UnauthorizedException extends RuntimeException {
    private final String code = "F03";
    private final String status = "Unauthorized";

    public UnauthorizedException() {
        super("Unauthorized");
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
