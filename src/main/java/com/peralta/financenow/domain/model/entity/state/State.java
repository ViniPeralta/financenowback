package com.peralta.financenow.domain.model.entity.state;

import com.peralta.financenow.domain.model.entity.country.Country;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
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
