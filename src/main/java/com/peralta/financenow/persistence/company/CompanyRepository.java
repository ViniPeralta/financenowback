package com.peralta.financenow.persistence.company;

import com.peralta.financenow.domain.model.entity.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = "SELECT tc.* FROM tb_company tc " +
            "INNER JOIN tb_address ta ON tc.address_id = ta.id " +
            "WHERE ta.zip_code = :zipCode " +
            "AND UPPER(tc.name) = UPPER(:name) " +
            "AND tc.user_id = :user", nativeQuery = true)
    Company getCompanyByZipCodeAndName(String zipCode, String name, Long user);

}
