package com.peralta.financenow.domain.model.entity.address;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_state")
public class State {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String abbreviation;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

}
