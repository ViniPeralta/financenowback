package com.peralta.financenow.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataListResponse<T> {

    private String message;

    private List<T> data;

    public DataListResponse(List<T> data) {
        this.message = "Successfull Operation";
        this.data = data;
    }

}
