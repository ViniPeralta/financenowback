package com.peralta.financenow.exception;

import lombok.Getter;

@Getter
public class FinanceNowException extends Exception {

    private final Integer errorCode;

    private final String message;

    private final String path;

    public FinanceNowException(Integer errorCode, String message, String path){
        this.errorCode = errorCode;
        this.message = message;
        this.path = path;
    }

}
