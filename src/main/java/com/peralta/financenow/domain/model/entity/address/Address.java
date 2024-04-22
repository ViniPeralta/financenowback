package com.peralta.financenow.domain.model.entity.address;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String addressInfo;

    @Column
    private String number;

    @Column(name = "zip_code")
    private String zipCode;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

}
