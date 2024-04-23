package com.peralta.financenow.persistence.city;

import com.peralta.financenow.domain.model.entity.address.City;
import com.peralta.financenow.domain.model.response.filter.FilterResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "SELECT new com.peralta.financenow.domain.model.response.filter.FilterResponse(" +
            "   tc.id, " +
            "   tc.name" +
            ")" +
            "FROM City tc " +
            "WHERE UPPER(tc.name) LIKE UPPER(CONCAT('%', :strSearch , '%')) " +
            "ORDER BY CASE " +
            "   WHEN tc.name = 'Sao Paulo' THEN 1 " +
            "   ELSE 2 " +
            "END, " +
            "tc.name " +
            "LIMIT :pageSize")
    List<FilterResponse> getCityFilterData(String strSearch, Long pageSize);

}
