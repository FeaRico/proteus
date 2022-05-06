package ru.makhach.vesselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.makhach.vesselmanager.model.entity.Country;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    @Query(value = "select country from Country country where country.code = ?1")
    Optional<Country> findCountryEntityByCode(String code);
}
