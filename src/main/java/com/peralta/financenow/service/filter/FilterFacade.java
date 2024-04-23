package com.peralta.financenow.service.filter;

import com.peralta.financenow.domain.enums.exception.FinanceNowExceptionEnum;
import com.peralta.financenow.domain.enums.filter.FilterEnum;
import com.peralta.financenow.domain.model.request.filter.FilterRequest;
import com.peralta.financenow.domain.model.response.DataListResponse;
import com.peralta.financenow.domain.model.response.filter.FilterResponseMap;
import com.peralta.financenow.exception.FinanceNowException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component

public class FilterFacade<R> {

    private final Map<FilterEnum, IFilterService<R>> services = new EnumMap<>(FilterEnum.class);

    public FilterFacade(List<IFilterService<R>> filterServices) {
        filterServices.forEach(filter -> services.put(filter.getType(), filter));
    }

    public DataListResponse<FilterResponseMap<R>> getFilters(FilterRequest filterRequest) throws FinanceNowException {
        List<FilterResponseMap<R>> response = new ArrayList<>();
        filterRequest.getFilterKeys().forEach(key ->
                FilterEnum.getByKey(key).ifPresentOrElse(
                        filterEnum -> response.add(
                                new FilterResponseMap<>(
                                        filterEnum.getKey(),
                                        filterEnum.getDescription(),
                                        getService(filterEnum).getFilterData(filterRequest)
                                )),
                        () -> {
                            throw new FinanceNowException(
                                    FinanceNowExceptionEnum.FILTER_NOT_FOUND.getErrorCode(),
                                    FinanceNowExceptionEnum.FILTER_NOT_FOUND.getDescription(),
                                    "FilterFacade.getFilters"
                            );
                        }));
        return new DataListResponse<>(response);
    }

    private IFilterService<R> getService(FilterEnum filterEnum) {
        return services.get(filterEnum);
    }
}
