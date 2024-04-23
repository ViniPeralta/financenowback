package com.peralta.financenow.service.filter.impl;

import com.peralta.financenow.domain.enums.filter.FilterEnum;
import com.peralta.financenow.domain.model.request.filter.FilterRequest;
import com.peralta.financenow.domain.model.response.filter.FilterResponse;
import com.peralta.financenow.persistence.city.CityRepository;
import com.peralta.financenow.service.filter.IFilterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityFilterService implements IFilterService<FilterResponse> {

    private final CityRepository cityRepository;

    public CityFilterService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public FilterEnum getType() {
        return FilterEnum.CITY;
    }

    @Override
    public List<FilterResponse> getFilterData(FilterRequest request) {
        return cityRepository.getCityFilterData(request.getStrSearch(), request.getPageSize());
    }
}
