package templates.state;

import com.peralta.financenow.domain.model.entity.address.State;
import templates.country.CountryTemplates;

public class StateTemplates {

    public static State getState() {
        return State.builder()
                .id(1L)
                .name("State")
                .abbreviation("ST")
                .country(CountryTemplates.getCountry())
                .build();
    }
}
