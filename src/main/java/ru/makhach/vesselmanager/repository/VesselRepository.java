package ru.makhach.vesselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.makhach.vesselmanager.model.entity.Vessel;
import ru.makhach.vesselmanager.model.util.Status;
import ru.makhach.vesselmanager.model.util.Type;

import java.util.List;

public interface VesselRepository extends JpaRepository<Vessel, Long> {
    List<Vessel> findAllByStatus(Status status);

    List<Vessel> findAllByType(Type type);

    @Query("select vessel from Vessel vessel where vessel.yearBuilt = ?1 group by vessel.yearBuilt")
    List<Vessel> findAllByYearBuilt(Integer yearBuilt);

    @Query("select vessel from Vessel vessel join Country country where country.id = ?1 group by country.id")
    List<Vessel> findAllByCountry(Long countryId);

    @Query("select vessel from Vessel vessel where vessel.currentPort.id = ?1")
    List<Vessel> findAllByCurrentPort(Long currentPortId);

    @Query("select vessel from Vessel vessel where vessel.homePort.id = ?1")
    List<Vessel> findAllByHomePort(Long homePortId);

    @Query("select vessel from Vessel vessel join Dock dock where dock.id = ?1")
    List<Vessel> findAllByDock(Long dockId);

    @Query("select vessel from Vessel vessel where vessel.name like '?1%' group by vessel.name")
    List<Vessel> findAllByNameStartsWith(String name);

    @Query("select vessel from Vessel vessel where vessel.name = ?1 group by vessel.id")
    List<Vessel> findAllByName(String name);
}
