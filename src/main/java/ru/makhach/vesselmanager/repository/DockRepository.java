package ru.makhach.vesselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.makhach.vesselmanager.model.entity.DockEntity;

import java.util.List;

public interface DockRepository extends JpaRepository<DockEntity, Long> {
    @Query("select dock from DockEntity dock where dock.port.id = ?1")
    List<DockEntity> findAllByPort(Long portId);
}
