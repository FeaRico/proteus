package ru.makhach.vesselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.makhach.vesselmanager.model.entity.Dock;

import java.util.List;

public interface DockRepository extends JpaRepository<Dock, Long> {
    @Query("select dock from Dock dock join Port port where port.id = ?1")
    List<Dock> findAllByPort(Long portId);
}
