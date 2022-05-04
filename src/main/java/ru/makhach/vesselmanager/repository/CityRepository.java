package ru.makhach.vesselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.makhach.vesselmanager.model.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
}
