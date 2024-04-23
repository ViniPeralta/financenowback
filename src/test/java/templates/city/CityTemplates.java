package templates.city;

import com.peralta.financenow.domain.model.entity.city.City;
import templates.state.StateTemplates;

public class CityTemplates {

    public static City getCity() {
        return City.builder()
                .id(1L)
                .name("City")
                .abbreviation("CT")
                .state(StateTemplates.getState())
                .build();
    }
}
