package com.asti.bashdata.common.codes;

import org.springframework.http.HttpStatus;

public enum ErrorCode implements BusinessCode {
    ;

    @Override
    public HttpStatus getHttpStatus() {
        return null;
    }

    @Override
    public String getCode() {
        return "";
    }

    @Override
    public String getMessage() {
        return "";
    }
}
