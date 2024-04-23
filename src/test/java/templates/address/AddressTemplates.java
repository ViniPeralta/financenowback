package templates.address;

import com.peralta.financenow.domain.model.entity.address.Address;
import templates.city.CityTemplates;

public class AddressTemplates {

    public static Address getAddress() {
        return Address.builder()
                .id(1L)
                .addressInfo("Address")
                .number("Number")
                .zipCode("ZipCode")
                .city(CityTemplates.getCity())
                .build();
    }
}
