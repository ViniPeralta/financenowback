package com.peralta.financenow.service.transaction;

import com.peralta.financenow.domain.model.request.transaction.TransactionByDateRequest;
import com.peralta.financenow.domain.model.request.transaction.TransactionDTO;
import com.peralta.financenow.domain.model.request.transaction.TransactionExtractRequest;
import com.peralta.financenow.exception.FinanceNowException;
import com.peralta.financenow.domain.model.entity.Transaction;
import com.peralta.financenow.domain.model.request.transaction.TransactionRequest;
import com.peralta.financenow.domain.model.response.DataListResponse;
import com.peralta.financenow.domain.model.response.DataResponse;
import com.peralta.financenow.domain.model.response.extract.ExtractResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface ITransactionService {

    ExtractResponse getTransactionsExtract(TransactionExtractRequest request) throws FinanceNowException;

    DataListResponse<Transaction> getTransactionByDate(TransactionByDateRequest request) throws FinanceNowException;

    DataResponse<Transaction> registerNewTransaction(TransactionRequest request) throws FinanceNowException;

    DataListResponse<Transaction> deleteByIdList(List<Long> idList) throws FinanceNowException;

    DataListResponse<Transaction> updateById(LocalDate dateFrom, LocalDate dateTo, TransactionDTO request) throws FinanceNowException;

}
