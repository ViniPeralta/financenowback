package com.peralta.financenow.domain.model.response.filter;

import lombok.Data;

import java.util.List;

@Data
public class FilterResponseMap<R> {

    private Long filterId;

    private String key;

    private List<R> filterResponse;

}
