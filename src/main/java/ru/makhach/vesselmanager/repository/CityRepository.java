package ru.makhach.vesselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.makhach.vesselmanager.model.entity.CityEntity;

import java.util.List;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
    @Query(value = "select city from CityEntity city where city.country.id = ?1")
    List<CityEntity> findAllByCountry(Long countryId);
}
