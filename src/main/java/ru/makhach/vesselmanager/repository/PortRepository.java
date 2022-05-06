package ru.makhach.vesselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.makhach.vesselmanager.model.entity.Port;

import java.util.List;

public interface PortRepository extends JpaRepository<Port, Long> {
    @Query("select port from Port port where port.city.id = ?1")
    List<Port> findAllByCity(Long cityId);

    @Query("select port from Port port join City city join Country country where country.id = ?1")
    List<Port> findAllByCountry(Long countryId);
}
