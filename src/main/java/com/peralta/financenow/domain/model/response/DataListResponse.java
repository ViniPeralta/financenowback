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

    private List<T> data;

    private String message;

    public DataListResponse(List<T> data) {
        this.data = data;
    }

}
