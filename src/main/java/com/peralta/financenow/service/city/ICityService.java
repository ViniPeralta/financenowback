package com.peralta.financenow.service.city;

import com.peralta.financenow.domain.model.entity.city.City;
import com.peralta.financenow.exception.FinanceNowException;
import org.springframework.stereotype.Component;

@Component
public interface ICityService {

    City findById(Long cityId) throws FinanceNowException;
}
