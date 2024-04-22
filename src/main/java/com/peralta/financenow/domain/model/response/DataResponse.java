package com.peralta.financenow.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse<T> {

    private T data;

    private String message;

    public DataResponse(T data) {
        this.data = data;
        this.message = "Successful operation";
    }

}
