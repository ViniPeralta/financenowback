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
@Table(name = "tb_city")
public class City {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String abbreviation;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    private State state;

}
