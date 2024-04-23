package com.peralta.financenow.controller;

import com.peralta.financenow.domain.model.entity.company.Company;
import com.peralta.financenow.domain.model.request.company.CompanyCreateRequest;
import com.peralta.financenow.domain.model.response.DataResponse;
import com.peralta.financenow.exception.FinanceNowException;
import com.peralta.financenow.service.company.ICompanyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "company")
@CrossOrigin(origins = "*")
public class CompanyController {

    private final ICompanyService iCompanyService;

    public CompanyController(ICompanyService iCompanyService) {
        this.iCompanyService = iCompanyService;
    }

    @PostMapping("/create")
    public DataResponse<Company> createCompany(
            @RequestBody CompanyCreateRequest companyCreateRequest
    ) throws FinanceNowException {

        return iCompanyService.createCompany(companyCreateRequest);

    }

}
