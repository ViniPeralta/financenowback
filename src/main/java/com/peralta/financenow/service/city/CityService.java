package com.peralta.financenow.service.city;

import com.peralta.financenow.domain.enums.exception.FinanceNowExceptionEnum;
import com.peralta.financenow.domain.model.entity.city.City;
import com.peralta.financenow.exception.FinanceNowException;
import com.peralta.financenow.persistence.city.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City findById(Long cityId) throws FinanceNowException {
        return cityRepository.findById(cityId)
                .orElseThrow(() ->
                        new FinanceNowException(
                                FinanceNowExceptionEnum.CITY_NOT_FOUND.getErrorCode(),
                                FinanceNowExceptionEnum.CITY_NOT_FOUND.getDescription(),
                                "CompanyService.createCompany"
                        ));
    }
}
