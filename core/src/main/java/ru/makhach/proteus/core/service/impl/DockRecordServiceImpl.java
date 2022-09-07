package ru.makhach.proteus.core.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.makhach.proteus.core.exceptions.ResourceNotFoundException;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.entity.DockRecord;
import ru.makhach.proteus.core.repository.DockRecordRepository;
import ru.makhach.proteus.core.service.DockRecordService;
import ru.makhach.proteus.core.utils.PageableUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DockRecordServiceImpl implements DockRecordService {
    private final DockRecordRepository recordRepository;

    public DockRecordServiceImpl(DockRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DockRecord> getAll() {
        return recordRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DockRecord> getAllPageable(PageRequest request) {
        Pageable pageable = PageableUtils.pageableFromRequest(request);
        return recordRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DockRecord> getAllByDock(Long id) {
        return recordRepository.findAllByDock(id)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<DockRecord> getAllByVessel(Long vesselId) {
        return recordRepository.findAllByVessel(vesselId)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DockRecord getById(Long id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(DockRecord.class, "id", id));
    }

    @Override
    public DockRecord update(DockRecord dockRecord) {
        Long id = dockRecord.getId();
        recordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(DockRecord.class, "id", id));

        return recordRepository.save(dockRecord);
    }

    @Override
    public DockRecord save(DockRecord dockRecord) {
        return recordRepository.save(dockRecord);
    }

    @Override
    public DockRecord delete(Long id) {
        DockRecord dockRecord = getById(id);
        recordRepository.delete(dockRecord);
        return dockRecord;
    }
}
