package com.peralta.financenow.domain.model.entity;

import com.peralta.financenow.domain.enums.company.CompanyStatusEnum;
import com.peralta.financenow.domain.enums.transaction.TransactionTypeEnum;
import com.peralta.financenow.domain.model.entity.address.Address;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phone;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column
    private Byte image;

    @Column(name = "sale_percentage")
    private Long salePercentage;

    @Column(name = "work_percentage")
    private Long workPercentage;

    @Column
    @Enumerated(EnumType.STRING)
    private CompanyStatusEnum status;
}
