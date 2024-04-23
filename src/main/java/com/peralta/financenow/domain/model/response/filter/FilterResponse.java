package com.peralta.financenow.domain.model.response.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FilterResponse {

    private Long id;

    private String value;

}
