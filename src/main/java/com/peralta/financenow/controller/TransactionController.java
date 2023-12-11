package com.peralta.financenow.controller;

import com.peralta.financenow.domain.model.request.transaction.TransactionByDateRequest;
import com.peralta.financenow.domain.model.request.transaction.TransactionDTO;
import com.peralta.financenow.domain.model.request.transaction.TransactionExtractRequest;
import com.peralta.financenow.exception.FinanceNowException;
import com.peralta.financenow.domain.model.entity.Transaction;
import com.peralta.financenow.domain.model.request.transaction.TransactionRequest;
import com.peralta.financenow.domain.model.response.DataListResponse;
import com.peralta.financenow.domain.model.response.DataResponse;
import com.peralta.financenow.domain.model.response.extract.ExtractResponse;
import com.peralta.financenow.service.transaction.ITransactionService;
import com.peralta.financenow.utils.DateUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "transaction")
@CrossOrigin(origins = "*")
public class TransactionController {

    private final ITransactionService transactionService;

    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/extract")
    public ExtractResponse getTransactionsExtract(
            @RequestParam(name = "month") String month,
            @RequestParam(name = "year") String year,
            @RequestParam(name = "user") Long user,
            @RequestParam(name = "type", required = false) String type,
            @RequestParam(name = "essential", required = false) Boolean essential
    ) throws FinanceNowException {

        return transactionService.getTransactionsExtract(new TransactionExtractRequest(month, year, user, type, essential));

    }

    @GetMapping("/list")
    public DataListResponse<Transaction> getTransactionsByDate(
            @RequestParam(name = "dateFrom") String dateFrom,
            @RequestParam(name = "dateTo") String dateTo,
            @RequestParam(name = "userId") Long userId
    ) throws FinanceNowException {

        return transactionService.getTransactionByDate(
                TransactionByDateRequest.builder()
                        .dateFrom(DateUtil.ddMMyyyytoLocalDate(dateFrom))
                        .dateTo(DateUtil.ddMMyyyytoLocalDate(dateTo))
                        .userId(userId)
                        .build());

    }

    @DeleteMapping("/delete")
    public DataListResponse<Transaction> deleteByIdList(
            @RequestParam(name = "idList") List<Long> idList
    ) throws FinanceNowException {

        return transactionService.deleteByIdList(idList);

    }

    @PostMapping("/register")
    public DataResponse<Transaction> registerNewTransaction(
            @RequestBody TransactionRequest request
    ) throws FinanceNowException {

        return transactionService.registerNewTransaction(request);

    }

    @PostMapping(
            value = "/update",
            consumes = "application/json",
            produces = "application/json"
    )
    public DataListResponse<Transaction> updateTransaction(
            @RequestBody TransactionDTO transaction,
            @RequestParam(name = "dateFrom") String dateFrom,
            @RequestParam(name = "dateTo") String dateTo
    ) throws FinanceNowException {

        return transactionService.updateById(
                DateUtil.ddMMyyyytoLocalDate(dateFrom),
                DateUtil.ddMMyyyytoLocalDate(dateTo),
                transaction
        );

    }
}
