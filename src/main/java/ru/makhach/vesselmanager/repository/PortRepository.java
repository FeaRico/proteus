package ru.makhach.vesselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.makhach.vesselmanager.model.entity.PortEntity;

public interface PortRepository extends JpaRepository<PortEntity, Long> {
}
