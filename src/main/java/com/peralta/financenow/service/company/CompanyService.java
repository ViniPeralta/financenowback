package com.peralta.financenow.service.company;

import com.peralta.financenow.domain.enums.exception.FinanceNowExceptionEnum;
import com.peralta.financenow.domain.model.entity.company.Company;
import com.peralta.financenow.domain.model.entity.user.User;
import com.peralta.financenow.domain.model.entity.city.City;
import com.peralta.financenow.domain.model.request.company.CompanyCreateRequest;
import com.peralta.financenow.domain.model.response.DataResponse;
import com.peralta.financenow.exception.FinanceNowException;
import com.peralta.financenow.mapper.company.CompanyMapper;
import com.peralta.financenow.persistence.company.CompanyRepository;
import com.peralta.financenow.service.city.ICityService;
import com.peralta.financenow.service.user.IUserService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CompanyService implements ICompanyService {

    private final CompanyRepository companyRepository;

    private final IUserService userService;

    private final ICityService cityService;

    public CompanyService(CompanyRepository companyRepository, IUserService userService, ICityService cityService) {
        this.companyRepository = companyRepository;
        this.userService = userService;
        this.cityService = cityService;
    }

    @Override
    public DataResponse<Company> createCompany(CompanyCreateRequest request) throws FinanceNowException {

        User user = userService.findById(request.getUserId());

        City city = cityService.findById(request.getCity());

        if (Objects.nonNull(companyRepository.getCompanyByZipCodeAndName(request.getZipCode(), request.getCompany(), user.getId()))) {
            throw new FinanceNowException(
                    FinanceNowExceptionEnum.COMPANY_ALREADY_EXISTS.getErrorCode(),
                    FinanceNowExceptionEnum.COMPANY_ALREADY_EXISTS.getDescription(),
                    "CompanyService.createCompany"
            );
        }

        return new DataResponse<>(companyRepository.save(CompanyMapper.mapFromCreateRequest(request, city, user)));

    }
}
