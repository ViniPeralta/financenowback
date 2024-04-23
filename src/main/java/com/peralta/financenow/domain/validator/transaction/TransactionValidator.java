package com.peralta.financenow.domain.validator.transaction;

import com.peralta.financenow.domain.enums.exception.FinanceNowExceptionEnum;
import com.peralta.financenow.domain.model.entity.transaction.Transaction;
import com.peralta.financenow.domain.model.request.transaction.TransactionByDateRequest;
import com.peralta.financenow.domain.model.request.transaction.TransactionExtractRequest;
import com.peralta.financenow.exception.FinanceNowException;

import java.util.List;
import java.util.Objects;

public class TransactionValidator {

    private TransactionValidator() {
    }

    public static void validateExtractRequest(TransactionExtractRequest request) throws FinanceNowException {

        if (Objects.isNull(request.getYear()) || Objects.isNull(request.getMonth())) {

            throw new FinanceNowException(
                    FinanceNowExceptionEnum.EMPTY_REQUIRED_FIELD.getErrorCode(),
                    FinanceNowExceptionEnum.EMPTY_REQUIRED_FIELD.getDescription(),
                    "TransactionValidator.validateExtractRequest"
            );

        }

    }

    public static void validateTransactionList(List<Transaction> transactionList) throws FinanceNowException {

        if (transactionList.isEmpty()) {

            throw new FinanceNowException(
                    FinanceNowExceptionEnum.NO_TRANSACTIONS.getErrorCode(),
                    FinanceNowExceptionEnum.NO_TRANSACTIONS.getDescription(),
                    "TransactionValidator.validateTransactionList"
            );

        }

    }

    public static void validateTransactionByDateRequest(TransactionByDateRequest request) throws FinanceNowException {

        if (Objects.isNull(request.getDateFrom()) || Objects.isNull(request.getDateTo()) || Objects.isNull(request.getUserId())) {

            throw new FinanceNowException(
                    FinanceNowExceptionEnum.EMPTY_REQUIRED_FIELD.getErrorCode(),
                    FinanceNowExceptionEnum.EMPTY_REQUIRED_FIELD.getDescription(),
                    "TransactionValidator.validateTransactionByDateRequest"
            );

        }

        if (request.getDateFrom().isAfter(request.getDateTo())) {

            throw new FinanceNowException(
                    FinanceNowExceptionEnum.DATE_FROM_AFTER_DATE_TO.getErrorCode(),
                    FinanceNowExceptionEnum.DATE_FROM_AFTER_DATE_TO.getDescription(),
                    "TransactionValidator.validateTransactionByDateRequest"
            );

        }

    }

    public static void validateDeleteRequest(List<Long> idList) throws FinanceNowException {

        if (idList.isEmpty()) {

            throw new FinanceNowException(
                    FinanceNowExceptionEnum.EMPTY_REQUIRED_FIELD.getErrorCode(),
                    FinanceNowExceptionEnum.EMPTY_REQUIRED_FIELD.getDescription(),
                    "TransactionValidator.validateDeleteRequest"
            );

        }
    }

    public static void validateTransaction(Transaction transaction) throws FinanceNowException {

        if (Objects.isNull(transaction)) {

            throw new FinanceNowException(
                    FinanceNowExceptionEnum.TRANSACTION_NOT_FOUND.getErrorCode(),
                    FinanceNowExceptionEnum.TRANSACTION_NOT_FOUND.getDescription(),
                    "TransactionValidator.validateTransaction"
            );

        }

    }

}
