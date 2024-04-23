package com.peralta.financenow.exception.handler;

import com.peralta.financenow.exception.ErrorResponse;
import com.peralta.financenow.exception.FinanceNowException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(FinanceNowException.class)
    public ResponseEntity<ErrorResponse> handleFinanceNowException(FinanceNowException exception) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(exception.getMessage())
                .method(exception.getPath())
                .path(String.valueOf(exception.getStackTrace()[0]))
                .dateTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode()));

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message("Erro inesperado.")
                .exception(exception.getMessage())
                .method(exception.getStackTrace()[0].getMethodName())
                .path(String.valueOf(exception.getStackTrace()[0]))
                .dateTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
