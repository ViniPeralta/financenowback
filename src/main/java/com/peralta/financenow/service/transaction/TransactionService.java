package com.peralta.financenow.service.transaction;

import com.peralta.financenow.domain.enums.transaction.TransactionTypeEnum;
import com.peralta.financenow.domain.model.entity.transaction.Transaction;
import com.peralta.financenow.domain.model.entity.user.User;
import com.peralta.financenow.domain.model.request.transaction.TransactionByDateRequest;
import com.peralta.financenow.domain.model.request.transaction.TransactionDTO;
import com.peralta.financenow.domain.model.request.transaction.TransactionExtractRequest;
import com.peralta.financenow.domain.model.request.transaction.TransactionRequest;
import com.peralta.financenow.domain.model.response.DataListResponse;
import com.peralta.financenow.domain.model.response.DataResponse;
import com.peralta.financenow.domain.model.response.extract.ExtractResponse;
import com.peralta.financenow.domain.validator.transaction.TransactionValidator;
import com.peralta.financenow.domain.validator.user.UserValidator;
import com.peralta.financenow.exception.FinanceNowException;
import com.peralta.financenow.mapper.transaction.TransactionMapper;
import com.peralta.financenow.persistence.transaction.ITransactionRepositoryCustom;
import com.peralta.financenow.persistence.transaction.TransactionRepository;
import com.peralta.financenow.persistence.user.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    private final TransactionRepository transactionRepository;

    private final ITransactionRepositoryCustom transactionRepositoryCustom;

    private final UserRepository userRepository;

    public TransactionService(TransactionRepository transactionRepository,
                              ITransactionRepositoryCustom transactionRepositoryCustom,
                              UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.transactionRepositoryCustom = transactionRepositoryCustom;
        this.userRepository = userRepository;
    }

    @Override
    public ExtractResponse getTransactionsExtract(TransactionExtractRequest request) throws FinanceNowException {

        TransactionValidator.validateExtractRequest(request);

        List<Transaction> transactionList = transactionRepositoryCustom.getTransactionsByFilters(request);

        TransactionValidator.validateTransactionList(transactionList);

        BigDecimal balance = BigDecimal.ZERO;

        for (Transaction transaction : transactionList) {
            if (transaction.getType().equals(TransactionTypeEnum.CREDIT)) {
                balance = balance.add(transaction.getValue());
            } else {
                balance = balance.subtract(transaction.getValue());
            }
        }

        return ExtractResponse.builder()
                .transactions(transactionList)
                .balance(balance)
                .build();
    }

    @Override
    public DataListResponse<Transaction> getTransactionByDate(TransactionByDateRequest request) throws FinanceNowException {

        TransactionValidator.validateTransactionByDateRequest(request);

        List<Transaction> transactionList = transactionRepository.findByDateFromAndDateTo(request.getDateFrom(), request.getDateTo(), request.getUserId());

        TransactionValidator.validateTransactionList(transactionList);

        return new DataListResponse<>(transactionList);
    }

    @Override
    public DataResponse<Transaction> registerNewTransaction(TransactionRequest request) throws FinanceNowException {

        User user = userRepository.getById(request.getUserId());

        UserValidator.validateUser(user);

        return new DataResponse<>(transactionRepository.save(TransactionMapper.fromTransactionRequest(user, request)));
    }

    @Override
    public DataListResponse<Transaction> deleteByIdList(List<Long> idList) throws FinanceNowException {

        TransactionValidator.validateDeleteRequest(idList);

        List<Transaction> transactionList = transactionRepository.findByIdList(idList);

        TransactionValidator.validateTransactionList(transactionList);

        transactionRepository.deleteAll(transactionList);

        return new DataListResponse<>(transactionList);

    }

    @Override
    public DataListResponse<Transaction> updateById(LocalDate dateFrom, LocalDate dateTo, TransactionDTO request) throws FinanceNowException {

        Transaction transaction = transactionRepository.getTransactionById(request.getId());

        TransactionValidator.validateTransaction(transaction);

        TransactionMapper.updateTransaction(transaction, request);

        transactionRepository.save(transaction);

        List<Transaction> transactionList = transactionRepository.findByDateFromAndDateTo(dateFrom, dateTo, transaction.getUser().getId());

        TransactionValidator.validateTransactionList(transactionList);

        return new DataListResponse<>(transactionList);
    }
}
