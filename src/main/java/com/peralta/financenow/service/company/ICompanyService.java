package com.peralta.financenow.service.company;

import com.peralta.financenow.domain.model.entity.company.Company;
import com.peralta.financenow.domain.model.request.company.CompanyCreateRequest;
import com.peralta.financenow.domain.model.response.DataResponse;
import com.peralta.financenow.exception.FinanceNowException;
import org.springframework.stereotype.Component;

@Component
public interface ICompanyService {

    DataResponse<Company> createCompany(CompanyCreateRequest request) throws FinanceNowException;

}
