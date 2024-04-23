package com.peralta.financenow.mapper.company;

import com.peralta.financenow.domain.enums.company.CompanyStatusEnum;
import com.peralta.financenow.domain.model.entity.company.Company;
import com.peralta.financenow.domain.model.entity.user.User;
import com.peralta.financenow.domain.model.entity.address.Address;
import com.peralta.financenow.domain.model.entity.city.City;
import com.peralta.financenow.domain.model.request.company.CompanyCreateRequest;

public class CompanyMapper {

    private CompanyMapper() {}

    public static Company mapFromCreateRequest(CompanyCreateRequest request, City city, User user) {
        return Company.builder()
                .name(request.getCompany())
                .email(request.getEmail())
                .phone(request.getPhone())
                .user(user)
                .address(Address.builder()
                        .addressInfo(request.getAddress())
                        .number(request.getNumber())
                        .zipCode(request.getZipCode())
                        .city(city)
                        .build())
                .image(request.getImage())
                .salePercentage(request.getSalePercentage())
                .workPercentage(request.getWorkPercentage())
                .status(CompanyStatusEnum.A)
                .build();
    }
}
