package ru.makhach.proteus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.makhach.proteus.model.entity.Dock;

import java.util.List;

public interface DockRepository extends JpaRepository<Dock, Long> {
    @Query("select dock from Dock dock join Port port where port.id = ?1")
    List<Dock> findAllByPort(Long portId);

    @Query("select count(vessel) from Vessel vessel join Dock dock where dock.id = ?1")
    Integer countVesselByDock(Long dockId);
}
