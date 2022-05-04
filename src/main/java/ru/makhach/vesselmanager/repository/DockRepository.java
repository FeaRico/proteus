package ru.makhach.vesselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.makhach.vesselmanager.model.entity.DockEntity;

public interface DockRepository extends JpaRepository<DockEntity, Long> {
}
