package com.peralta.financenow.service.transaction;

import com.peralta.financenow.domain.enums.exception.FinanceNowExceptionEnum;
import com.peralta.financenow.domain.enums.transaction.TransactionTypeEnum;
import com.peralta.financenow.domain.model.entity.Transaction;
import com.peralta.financenow.domain.model.request.transaction.TransactionByDateRequest;
import com.peralta.financenow.domain.model.request.transaction.TransactionExtractRequest;
import com.peralta.financenow.domain.model.response.extract.ExtractResponse;
import com.peralta.financenow.exception.FinanceNowException;
import com.peralta.financenow.persistence.transaction.ITransactionRepositoryCustom;
import com.peralta.financenow.persistence.transaction.TransactionRepository;
import com.peralta.financenow.persistence.user.UserRepository;
import com.peralta.financenow.utils.DateUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import templates.transaction.TransactionTemplates;
import templates.user.UserTemplates;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private ITransactionRepositoryCustom transactionRepositoryCustom;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("Should throw an EMPTY_REQUIRED_FIELD exception")
    void getTransactionsExtractError() {

        TransactionExtractRequest transactionRequest = TransactionTemplates.getTransactionExtractRequest();
        transactionRequest.setMonth(null);

        FinanceNowException exception = null;

        try {
            transactionService.getTransactionsExtract(transactionRequest);
        } catch (FinanceNowException ex) {
            exception = ex;
        }

        assertNotNull(exception);
        assertEquals(FinanceNowExceptionEnum.EMPTY_REQUIRED_FIELD.getDescription(), exception.getMessage());

    }

    @Test
    @DisplayName("Should throw an NO_TRANSACTIONS exception")
    void getTransactionsExtractErrorII() {

        when(transactionRepositoryCustom.getTransactionsByFilters(any())).thenReturn(new ArrayList<>());

        FinanceNowException exception = null;

        try {
            transactionService.getTransactionsExtract(TransactionTemplates.getTransactionExtractRequest());
        } catch (FinanceNowException ex) {
            exception = ex;
        }

        assertNotNull(exception);
        assertEquals(FinanceNowExceptionEnum.NO_TRANSACTIONS.getDescription(), exception.getMessage());

    }

    @Test
    @DisplayName("Should return transaction extract")
    void getTransactionsExtract() throws FinanceNowException {

        when(transactionRepositoryCustom.getTransactionsByFilters(any())).thenReturn(TransactionTemplates.getTransactionList());

        ExtractResponse response = transactionService.getTransactionsExtract(TransactionTemplates.getTransactionExtractRequest());

        assertAll(
                () -> assertEquals(BigDecimal.TEN, response.getBalance()),
                () -> assertEquals(2, response.getTransactions().size())
        );


    }

    @Test
    @DisplayName("Should throw an EMPTY_REQUIRED_FIELD exception")
    void getTransactionByDateError() {

        TransactionByDateRequest transactionRequest = TransactionTemplates.getTransactionByDateRequest();
        transactionRequest.setDateFrom(null);

        FinanceNowException exception = null;

        try {
            transactionService.getTransactionByDate(transactionRequest);
        } catch (FinanceNowException ex) {
            exception = ex;
        }

        assertNotNull(exception);
        assertEquals(FinanceNowExceptionEnum.EMPTY_REQUIRED_FIELD.getDescription(), exception.getMessage());

    }

    @Test
    @DisplayName("Should throw an DATE_FROM_AFTER_DATE_TO exception")
    void getTransactionByDateErrorII() {

        TransactionByDateRequest transactionRequest = TransactionTemplates.getTransactionByDateRequest();
        transactionRequest.setDateFrom(DateUtil.ddMMyyyytoLocalDate("11/10/2023"));

        FinanceNowException exception = null;

        try {
            transactionService.getTransactionByDate(transactionRequest);
        } catch (FinanceNowException ex) {
            exception = ex;
        }

        assertNotNull(exception);
        assertEquals(FinanceNowExceptionEnum.DATE_FROM_AFTER_DATE_TO.getDescription(), exception.getMessage());

    }

    @Test
    @DisplayName("Should return Transaction response")
    void getTransactionByDate() throws FinanceNowException {

        when(transactionRepository.findByDateFromAndDateTo(any(), any(), any())).thenReturn(TransactionTemplates.getTransactionList());

        List<Transaction> response = transactionService.getTransactionByDate(TransactionTemplates.getTransactionByDateRequest()).getData();

        assertAll(
                () -> assertEquals(2, response.size()
                )
        );

    }

    @Test
    @DisplayName("Should throw an USER_NOT_FOUND exception")
    void registerNewTransactionError() {

        FinanceNowException exception = null;

        try {
            transactionService.registerNewTransaction(TransactionTemplates.getTransactionRequest());
        } catch (FinanceNowException ex) {
            exception = ex;
        }

        assertNotNull(exception);
        assertEquals(FinanceNowExceptionEnum.USER_NOT_FOUND.getDescription(), exception.getMessage());

    }

    @Test
    @DisplayName("Should return a Transaction")
    void registerNewTransaction() throws FinanceNowException {

        Transaction expected = TransactionTemplates.getTransaction(TransactionTypeEnum.CREDIT, BigDecimal.TEN);

        when(userRepository.getById(any())).thenReturn(UserTemplates.getUser());
        when(transactionRepository.save(any())).thenReturn(expected);

        Transaction response = transactionService.registerNewTransaction(TransactionTemplates.getTransactionRequest()).getData();

        assertEquals(expected.getType().getValue(), response.getType().getValue());
        assertEquals(expected.getValue(), response.getValue());
        assertEquals(expected.getDescription(), response.getDescription());
        assertEquals(expected.getUser(), response.getUser());
        assertEquals(expected.getEssential(), response.getEssential());
        assertEquals(expected.getId(), response.getId());
        assertEquals(expected.getCategory(), response.getCategory());
        assertEquals(expected.getDate(), response.getDate());
    }

    @Test
    @DisplayName("Should throw EMPTY_REQUIRED_FIELD exception")
    void deleteByIdListError() {

        FinanceNowException exception = null;

        try {
            transactionService.deleteByIdList(new ArrayList<>());
        } catch (FinanceNowException ex) {
            exception = ex;
        }

        assertNotNull(exception);
        assertEquals(FinanceNowExceptionEnum.EMPTY_REQUIRED_FIELD.getDescription(), exception.getMessage());

    }

    @Test
    @DisplayName("Should return Transaction list")
    void deleteByIdList() throws FinanceNowException {

        List<Transaction> expected = TransactionTemplates.getTransactionList();

        when(transactionRepository.findByIdList(any())).thenReturn(expected);

        List<Transaction> response = transactionService.deleteByIdList(List.of(1L)).getData();

        assertEquals(expected, response);

    }

    @Test
    @DisplayName("Should return TRANSACTION_NOT_FOUND exception")
    void updateByIdError() {

        FinanceNowException exception = null;

        try {
            transactionService.updateById(
                    DateUtil.ddMMyyyytoLocalDate("10/02/2023"),
                    DateUtil.ddMMyyyytoLocalDate("10/02/2023"),
                    TransactionTemplates.getTransactionDTO());
        } catch (FinanceNowException ex) {
            exception = ex;
        }

        assertNotNull(exception);
        assertEquals(FinanceNowExceptionEnum.TRANSACTION_NOT_FOUND.getDescription(), exception.getMessage());
    }

    @Test
    @DisplayName("Should return a Transaction list")
    void updateById() throws FinanceNowException {

        List<Transaction> expected = TransactionTemplates.getTransactionList();

        when(transactionRepository.findByDateFromAndDateTo(any(), any(), any())).thenReturn(expected);
        when(transactionRepository.getTransactionById(any())).thenReturn(TransactionTemplates.getTransaction(TransactionTypeEnum.CREDIT, BigDecimal.TEN));

        List<Transaction> response = transactionService.updateById(
                        DateUtil.ddMMyyyytoLocalDate("10/02/2023"),
                        DateUtil.ddMMyyyytoLocalDate("10/02/2023"),
                        TransactionTemplates.getTransactionDTO())
                .getData();

        assertEquals(expected, response);

    }
}