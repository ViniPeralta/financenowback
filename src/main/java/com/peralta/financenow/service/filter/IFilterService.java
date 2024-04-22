package com.peralta.financenow.service.filter;

import com.peralta.financenow.domain.enums.filter.FilterEnum;
import com.peralta.financenow.domain.model.request.filter.FilterRequest;
import com.peralta.financenow.domain.model.response.filter.FilterResponseMap;

public interface IFilterService<R> {

    FilterEnum getType();

    FilterResponseMap<R> getFilterData(FilterRequest request);

}
