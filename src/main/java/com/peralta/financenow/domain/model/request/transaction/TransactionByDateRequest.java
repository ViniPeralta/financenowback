package com.peralta.financenow.domain.model.request.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionByDateRequest {

    private LocalDate dateFrom;

    private LocalDate dateTo;

    private Long userId;

}
