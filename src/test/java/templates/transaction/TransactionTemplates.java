package templates.transaction;

import com.peralta.financenow.domain.enums.transaction.TransactionTypeEnum;
import com.peralta.financenow.domain.model.entity.transaction.Transaction;
import com.peralta.financenow.domain.model.request.transaction.TransactionByDateRequest;
import com.peralta.financenow.domain.model.request.transaction.TransactionDTO;
import com.peralta.financenow.domain.model.request.transaction.TransactionExtractRequest;
import com.peralta.financenow.domain.model.request.transaction.TransactionRequest;
import com.peralta.financenow.utils.DateUtil;
import templates.user.UserTemplates;

import java.math.BigDecimal;
import java.util.List;

public class TransactionTemplates {

    public static TransactionRequest getTransactionRequest() {
        return TransactionRequest.builder()
                .userId(1L)
                .type("CREDIT")
                .value(BigDecimal.TEN)
                .essential(Boolean.FALSE)
                .category("Test")
                .description("Test request")
                .date("10/12/2023")
                .build();
    }

    public static TransactionDTO getTransactionDTO() {
        return TransactionDTO.builder()
                .id(1L)
                .type(TransactionTypeEnum.CREDIT)
                .value(BigDecimal.TEN)
                .essential(Boolean.FALSE)
                .category("Test")
                .description("Test DTO")
                .date("10/12/2023")
                .build();
    }

    public static TransactionExtractRequest getTransactionExtractRequest() {
        return TransactionExtractRequest.builder()
                .month("1")
                .year("2023")
                .user(1L)
                .type("CREDIT")
                .essential(Boolean.FALSE)
                .build();
    }

    public static List<Transaction> getTransactionList() {
        return List.of(
                getTransaction(TransactionTypeEnum.CREDIT, BigDecimal.valueOf(20L)),
                getTransaction(TransactionTypeEnum.DEBIT, BigDecimal.TEN)
        );
    }

    public static Transaction getTransaction(TransactionTypeEnum transactionTypeEnum, BigDecimal value) {
        return Transaction.builder()
                .user(UserTemplates.getUser())
                .id(1L)
                .type(transactionTypeEnum)
                .value(value)
                .essential(Boolean.FALSE)
                .category("category")
                .description("description")
                .date(DateUtil.ddMMyyyytoLocalDate("10/02/2023"))
                .build();
    }

    public static TransactionByDateRequest getTransactionByDateRequest() {
        return TransactionByDateRequest.builder()
                .dateFrom(DateUtil.ddMMyyyytoLocalDate("10/02/2023"))
                .dateTo(DateUtil.ddMMyyyytoLocalDate("10/02/2023"))
                .userId(1L)
                .build();
    }
}
