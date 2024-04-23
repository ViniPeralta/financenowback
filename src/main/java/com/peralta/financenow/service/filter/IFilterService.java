package com.peralta.financenow.service.filter;

import com.peralta.financenow.domain.enums.filter.FilterEnum;
import com.peralta.financenow.domain.model.request.filter.FilterRequest;

import java.util.List;

public interface IFilterService<R> {

    FilterEnum getType();

    List<R> getFilterData(FilterRequest request);

}
