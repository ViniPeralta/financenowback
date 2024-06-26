package com.peralta.financenow.domain.model.entity.city;

import com.peralta.financenow.domain.model.entity.state.State;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
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
