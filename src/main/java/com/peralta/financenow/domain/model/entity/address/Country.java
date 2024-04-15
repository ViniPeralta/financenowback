package com.peralta.financenow.domain.model.entity.address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_country")
public class Country {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String abbreviation;

}
