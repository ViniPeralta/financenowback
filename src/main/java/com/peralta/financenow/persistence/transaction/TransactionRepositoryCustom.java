package com.peralta.financenow.persistence.transaction;

import com.peralta.financenow.domain.model.entity.Transaction;
import com.peralta.financenow.domain.model.request.transaction.TransactionExtractRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TransactionRepositoryCustom implements ITransactionRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Transaction> getTransactionsByFilters(TransactionExtractRequest request) {

        StringBuilder sqlString = new StringBuilder(
                "SELECT * FROM tb_extract" +
                        " WHERE MONTH(transfer_date) = " + request.getMonth() +
                        " AND YEAR(transfer_date) = " + request.getYear() +
                        " AND user_id = " + request.getUser()
        );

        addFilters(sqlString, request);

        sqlString.append(" ORDER BY transfer_date");

        Query query = entityManager.createNativeQuery(sqlString.toString(), Transaction.class);

        return query.getResultList();

    }

    private void addFilters(StringBuilder query, TransactionExtractRequest request) {

        if (Objects.nonNull(request.getType())) {
            query.append(" AND transfer_type = '").append(request.getType()).append("'");
        }

        if (Objects.nonNull(request.getEssential())) {
            query.append(" AND essential = ").append(request.getEssential());
        }

    }
}
