package ru.makhach.proteus.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.makhach.proteus.core.model.entity.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    @Query(value = "select city from City city where city.country.id = ?1")
    List<City> findAllByCountry(Long countryId);
}
