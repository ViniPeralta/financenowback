package com.peralta.financenow.service.filter.impl;

import com.peralta.financenow.domain.enums.filter.FilterEnum;
import com.peralta.financenow.domain.model.response.filter.FilterResponse;
import com.peralta.financenow.persistence.city.CityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import templates.filter.FilterTemplates;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CityFilterServiceTest {

    @InjectMocks
    private CityFilterService cityFilterService;

    @Mock
    private CityRepository cityRepository;

    @Test
    @DisplayName("Should return filterEnum")
    void getType() {
        assertEquals(FilterEnum.CITY, cityFilterService.getType());
    }

    @Test
    @DisplayName("Should return filterResponse")
    void getFilterData() {

        FilterResponse expected = FilterTemplates.getFilterResponse();

        when(cityRepository.getCityFilterData(any(), any())).thenReturn(List.of(expected));

        FilterResponse response = cityFilterService.getFilterData(FilterTemplates.getFilterRequest()).get(0);

        assertEquals(expected, response);
    }

}