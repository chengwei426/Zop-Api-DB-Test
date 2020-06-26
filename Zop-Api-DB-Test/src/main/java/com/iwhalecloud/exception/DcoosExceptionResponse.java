package com.iwhalecloud.exception;

import java.io.Serializable;
import lombok.Data;

@Data
public class DcoosExceptionResponse implements Serializable {
    private String code;
    private String reason;
    private String message;
    private String status;
    private String referenceError;

    public DcoosExceptionResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
