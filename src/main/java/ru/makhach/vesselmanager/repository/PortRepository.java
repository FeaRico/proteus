package ru.makhach.vesselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.makhach.vesselmanager.model.entity.PortEntity;

import java.util.List;

public interface PortRepository extends JpaRepository<PortEntity, Long> {
    @Query("select port from PortEntity port where port.city.id = ?1")
    List<PortEntity> findAllByCity(Long cityId);

    @Query("select port from PortEntity port join CityEntity city join CountryEntity country where country.id = ?1")
    List<PortEntity> findAllByCountry(Long countryId);
}
