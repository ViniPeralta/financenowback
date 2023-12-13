package com.peralta.financenow.domain.enums.transaction;

import lombok.Getter;

@Getter
public enum TransactionTypeEnum {

    CREDIT("CREDIT"),

    DEBIT("DEBIT");

    private final String value;

    TransactionTypeEnum(String value) {
        this.value = value;
    }
}
