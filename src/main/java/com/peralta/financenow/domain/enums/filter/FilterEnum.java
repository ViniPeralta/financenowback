package com.peralta.financenow.domain.enums.filter;

import com.peralta.financenow.domain.enums.exception.FinanceNowExceptionEnum;
import com.peralta.financenow.exception.FinanceNowException;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum FilterEnum {

    CITY(0L, "City");

    private final Long key;

    private final String description;

    FilterEnum(Long key, String description) {
        this.key = key;
        this.description = description;
    }

    public static Optional<FilterEnum> getByKey(Long key) {
        return Arrays.stream(values()).filter(value -> value.getKey().equals(key))
                .findFirst();
    }
}
