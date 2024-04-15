package com.peralta.financenow.domain.enums.company;

import lombok.Getter;

@Getter
public enum CompanyStatusEnum {

    A("Active"),

    I("Inactive");

    private final String value;

    CompanyStatusEnum(String value) {
        this.value = value;
    }
}
