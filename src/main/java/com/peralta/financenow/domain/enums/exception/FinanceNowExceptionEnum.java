package com.peralta.financenow.domain.enums.exception;

import lombok.Getter;

@Getter
public enum FinanceNowExceptionEnum {

    USER_NOT_FOUND(404, "Usuário não encontrado."),

    EMPTY_REQUIRED_FIELD(500, "Campos obrigatórios não podem estar vazio."),

    NO_TRANSACTIONS(404, "Não há transações na data informada."),

    DATE_FROM_AFTER_DATE_TO(500, "Data inicial maior que a final."),

    TRANSACTION_NOT_FOUND(404, "Transação não encontrada."),

    USERNAME_ALREADY_EXISTS(500, "Usuário já cadastrado."),

    EMAIL_ALREADY_EXISTS(500, "E-mail já cadastrado."),

    CITY_NOT_FOUND(404, "Cidade não encontrada."),

    COMPANY_ALREADY_EXISTS(500, "Empresa já cadastrada."),

    FILTER_NOT_FOUND(500, "Filtro não encontrado.");

    private final Integer errorCode;

    private final String description;

    FinanceNowExceptionEnum(Integer errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }
}
