package com.peralta.financenow.persistence.transaction;

import com.peralta.financenow.domain.model.entity.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "select * from tb_extract where " +
            "(transfer_date between :dateFrom and :dateTo and user_id = :id) " +
            "order by transfer_date", nativeQuery = true)
    List<Transaction> findByDateFromAndDateTo(LocalDate dateFrom, LocalDate dateTo, Long id);

    @Query(value = "select * from tb_extract where id in (:idList)", nativeQuery = true)
    List<Transaction> findByIdList(List<Long> idList);

    @Query(value = "select * from tb_extract where id = :id", nativeQuery = true)
    Transaction getTransactionById(Long id);
}
