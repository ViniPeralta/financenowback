package templates.company;

import com.peralta.financenow.domain.enums.company.CompanyStatusEnum;
import com.peralta.financenow.domain.model.entity.company.Company;
import com.peralta.financenow.domain.model.request.company.CompanyCreateRequest;
import templates.address.AddressTemplates;
import templates.user.UserTemplates;

public class CompanyTemplates {

    public static CompanyCreateRequest getCompanyCreateRequest() {
        return CompanyCreateRequest.builder()
                .company("Company")
                .email("Email")
                .phone("Phone")
                .city(1L)
                .zipCode("ZipCode")
                .address("Address")
                .number("Number")
                .image(Byte.decode("120"))
                .salePercentage(10L)
                .workPercentage(100L)
                .userId(1L)
                .build();
    }

    public static Company getCompany() {
        return Company.builder()
                .id(1L)
                .name("Company")
                .email("Email")
                .phone("Phone")
                .user(UserTemplates.getUser())
                .address(AddressTemplates.getAddress())
                .image(Byte.decode("120"))
                .salePercentage(10L)
                .workPercentage(100L)
                .status(CompanyStatusEnum.A)
                .build();
    }
}
