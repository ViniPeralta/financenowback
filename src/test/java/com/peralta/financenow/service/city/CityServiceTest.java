package com.peralta.financenow.service.city;

import com.peralta.financenow.domain.model.entity.city.City;
import com.peralta.financenow.exception.FinanceNowException;
import com.peralta.financenow.persistence.city.CityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import templates.city.CityTemplates;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CityServiceTest {

    @InjectMocks
    private CityService cityService;

    @Mock
    private CityRepository cityRepository;

    @Test
    @DisplayName("Should return a city by id")
    void findById() {

        City expected = CityTemplates.getCity();

        when(cityRepository.findById(any())).thenReturn(Optional.of(expected));

        City response = cityService.findById(1L);

        assertEquals(expected, response);

    }

    @Test
    @DisplayName("Should throw CITY_NOT_FOUND exception")
    void findByIdError() {
        assertThrows(FinanceNowException.class, () -> cityService.findById(1L));
    }

}