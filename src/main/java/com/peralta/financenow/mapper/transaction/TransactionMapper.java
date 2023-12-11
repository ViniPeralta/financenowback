package com.peralta.financenow.mapper.transaction;

import com.peralta.financenow.domain.enums.transaction.TransactionTypeEnum;
import com.peralta.financenow.domain.model.entity.Transaction;
import com.peralta.financenow.domain.model.entity.User;
import com.peralta.financenow.domain.model.request.transaction.TransactionDTO;
import com.peralta.financenow.domain.model.request.transaction.TransactionRequest;
import com.peralta.financenow.utils.DateUtil;

public class TransactionMapper {

    private TransactionMapper() {
    }

    public static void updateTransaction(Transaction transaction, TransactionDTO updateRequest) {

        transaction.setType(updateRequest.getType());
        transaction.setValue(updateRequest.getValue());
        transaction.setEssential(updateRequest.getEssential());
        transaction.setCategory(updateRequest.getCategory());
        transaction.setDescription(updateRequest.getDescription());
        transaction.setDate(DateUtil.ddMMyyyytoLocalDate(updateRequest.getDate()));

    }

    public static Transaction fromTransactionRequest(User user, TransactionRequest request) {

        return Transaction.builder()
                .user(user)
                .type(TransactionTypeEnum.valueOf(request.getType()))
                .value(request.getValue())
                .essential(request.getEssential())
                .category(request.getCategory())
                .description(request.getDescription())
                .date(DateUtil.ddMMyyyytoLocalDate(request.getDate()))
                .build();

    }

}
