package ru.makhach.vesselmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.makhach.vesselmanager.model.entity.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}
