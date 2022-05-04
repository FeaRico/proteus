package ru.makhach.vesselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.makhach.vesselmanager.model.entity.CountryEntity;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
    @Query(value = "select country from CountryEntity country where country.code = ?1")
    Optional<CountryEntity> findCountryEntityByCode(String code);
}
