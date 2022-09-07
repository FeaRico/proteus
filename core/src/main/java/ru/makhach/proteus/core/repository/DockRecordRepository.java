package ru.makhach.proteus.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.makhach.proteus.core.model.entity.DockRecord;

import java.util.stream.Stream;

public interface DockRecordRepository extends JpaRepository<DockRecord, Long> {
    @Query("select record from DockRecord record join Dock dock where dock.id = ?1 group by dock.id")
    Stream<DockRecord> findAllByDock(Long id);

    @Query("select record from DockRecord record join Vessel vessel where vessel.id = ?1 group by vessel.id")
    Stream<DockRecord> findAllByVessel(Long vesselId);
}
