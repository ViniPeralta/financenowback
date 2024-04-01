package com.peralta.financenow.exception;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorResponse(String message, LocalDateTime dateTime, String method, String path) {}
