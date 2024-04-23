package com.peralta.financenow.domain.model.response.extract;

import com.peralta.financenow.domain.model.entity.transaction.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExtractResponse {

    private List<Transaction> transactions;

    private BigDecimal balance;

}
