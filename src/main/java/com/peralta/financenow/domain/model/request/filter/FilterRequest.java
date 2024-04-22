package com.peralta.financenow.domain.model.request.filter;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FilterRequest {

    private Long pageSize;

    private List<Long> filterKeys;

    private String strSearch;

    private List<Long> relatedIds;

}
