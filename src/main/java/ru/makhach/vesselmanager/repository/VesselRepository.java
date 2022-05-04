package ru.makhach.vesselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.makhach.vesselmanager.model.entity.VesselEntity;

public interface VesselRepository extends JpaRepository<VesselEntity, Long> {
}
