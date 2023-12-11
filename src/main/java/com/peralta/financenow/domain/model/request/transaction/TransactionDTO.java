package com.peralta.financenow.domain.model.request.transaction;

import com.peralta.financenow.domain.enums.transaction.TransactionTypeEnum;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    private Long id;

    private TransactionTypeEnum type;

    private BigDecimal value;

    private Boolean essential;

    private String category;

    private String description;

    private String date;

}
