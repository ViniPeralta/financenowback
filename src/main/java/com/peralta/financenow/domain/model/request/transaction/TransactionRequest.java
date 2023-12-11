package com.peralta.financenow.domain.model.request.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    private Long userId;

    private String type;

    private BigDecimal value;

    private Boolean essential;

    private String category;

    private String description;

    private String date;

}
