package ru.makhach.vesselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.makhach.vesselmanager.model.entity.VesselEntity;
import ru.makhach.vesselmanager.model.util.Status;
import ru.makhach.vesselmanager.model.util.Type;

import java.util.List;

public interface VesselRepository extends JpaRepository<VesselEntity, Long> {
    List<VesselEntity> findAllByStatus(Status status);

    List<VesselEntity> findAllByType(Type type);

    @Query("select vessel from VesselEntity vessel where vessel.yearBuilt = ?1 group by vessel.yearBuilt")
    List<VesselEntity> findAllByYearBuilt(Integer yearBuilt);

    @Query("select vessel from VesselEntity vessel join CountryEntity country where country.id = ?1 group by country.id")
    List<VesselEntity> findAllByCountry(Long countryId);

    @Query("select vessel from VesselEntity vessel where vessel.currentPort.id = ?1")
    List<VesselEntity> findAllByCurrentPort(Long currentPortId);

    @Query("select vessel from VesselEntity vessel where vessel.homePort.id = ?1")
    List<VesselEntity> findAllByHomePort(Long homePortId);

    @Query("select vessel from VesselEntity vessel join DockEntity dock where dock.id = ?1")
    List<VesselEntity> findAllByDock(Long dockId);

    @Query("select vessel from VesselEntity vessel where vessel.name like '?1%' group by vessel.name")
    List<VesselEntity> findAllByNameStartsWith(String name);

    @Query("select vessel from VesselEntity vessel where vessel.name = ?1 group by vessel.id")
    List<VesselEntity> findAllByName(String name);
}
