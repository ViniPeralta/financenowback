package com.peralta.financenow.service.company;

import com.peralta.financenow.domain.model.entity.Company;
import com.peralta.financenow.domain.model.entity.User;
import com.peralta.financenow.domain.model.entity.address.City;
import com.peralta.financenow.domain.model.request.company.CompanyCreateRequest;
import com.peralta.financenow.exception.FinanceNowException;
import com.peralta.financenow.persistence.company.CompanyRepository;
import com.peralta.financenow.service.city.ICityService;
import com.peralta.financenow.service.user.IUserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import templates.city.CityTemplates;
import templates.company.CompanyTemplates;
import templates.user.UserTemplates;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {

    @InjectMocks
    private CompanyService companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private IUserService iUserService;

    @Mock
    private ICityService iCityService;

    @Test
    @DisplayName("Should create a new company")
    void createCompany() {
        Company expectedCompany = CompanyTemplates.getCompany();

        when(iUserService.findById(any())).thenReturn(UserTemplates.getUser());
        when(iCityService.findById(any())).thenReturn(CityTemplates.getCity());
        when(companyRepository.save(any())).thenReturn(expectedCompany);

        Company response = companyService.createCompany(CompanyTemplates.getCompanyCreateRequest()).getData();

        assertEquals(expectedCompany, response);
    }

    @Test
    @DisplayName("Should throw COMPANY_ALREADY_EXISTS exception")
    void createCompanyError() {

        when(iUserService.findById(any())).thenReturn(UserTemplates.getUser());
        when(iCityService.findById(any())).thenReturn(CityTemplates.getCity());
        when(companyRepository.getCompanyByZipCodeAndName(any(), any(), any())).thenReturn(CompanyTemplates.getCompany());

        CompanyCreateRequest request = CompanyTemplates.getCompanyCreateRequest();

        assertThrows(FinanceNowException.class, () -> companyService.createCompany(request));

    }

}