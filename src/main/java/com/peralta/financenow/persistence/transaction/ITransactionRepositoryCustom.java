package com.peralta.financenow.persistence.transaction;

import com.peralta.financenow.domain.model.entity.Transaction;
import com.peralta.financenow.domain.model.request.transaction.TransactionExtractRequest;

import java.util.List;

public interface ITransactionRepositoryCustom {

    List<Transaction> getTransactionsByFilters(TransactionExtractRequest request);

}
