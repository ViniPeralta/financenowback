package com.peralta.financenow.domain.model.entity;

import com.peralta.financenow.domain.enums.transaction.TransactionTypeEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "tb_extract")
@NoArgsConstructor
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @NonNull
    @Column(name = "transfer_type")
    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum type;

    @NonNull
    @Column(name = "transfer_value")
    private BigDecimal value;

    @NonNull
    @Column(name = "essential")
    private Boolean essential;

    @NonNull
    @Column(name = "category")
    private String category;

    @NonNull
    @Column(name = "transfer_description")
    private String description;

    @NonNull
    @Column(name = "transfer_date")
    private LocalDate date;

}
