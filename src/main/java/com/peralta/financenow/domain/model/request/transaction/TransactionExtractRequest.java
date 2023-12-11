package com.peralta.financenow.domain.model.request.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionExtractRequest {

    private String month;

    private String year;

    private Long user;

    private String type;

    private Boolean essential;

}
