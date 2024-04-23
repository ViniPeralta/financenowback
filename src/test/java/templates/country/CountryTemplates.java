package templates.country;

import com.peralta.financenow.domain.model.entity.country.Country;

public class CountryTemplates {

    public static Country getCountry() {
        return Country.builder()
                .id(1L)
                .name("Country")
                .abbreviation("CO")
                .build();
    }
}
