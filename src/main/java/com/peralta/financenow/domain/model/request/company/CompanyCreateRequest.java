package com.peralta.financenow.domain.model.request.company;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class CompanyCreateRequest {

    @NonNull
    private String company;

    private String email;

    private String phone;

    @NonNull
    private Long city;

    @NonNull
    private String zipCode;

    @NonNull
    private String address;

    @NonNull
    private String number;

    private Byte image;

    @NonNull
    private Long salePercentage;

    @NonNull
    private Long workPercentage;

    @NonNull
    private Long userId;

}
