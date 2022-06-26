package ru.makhach.proteus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.makhach.proteus.model.dto.base.DockRecordDto;
import ru.makhach.proteus.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.model.dto.filter.pageable.PageResponse;
import ru.makhach.proteus.service.facade.DockRecordServiceFacade;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("api/v1/dock/records")
@Validated
public class DockRecordController {
    private final DockRecordServiceFacade dockRecordServiceFacade;

    public DockRecordController(DockRecordServiceFacade dockRecordServiceFacade) {
        this.dockRecordServiceFacade = dockRecordServiceFacade;
    }

    @GetMapping
    public ResponseEntity<List<DockRecordDto>> getAll() {
        return ResponseEntity.ok(dockRecordServiceFacade.getAll());
    }

    @GetMapping("/pageable")
    public ResponseEntity<PageResponse<List<DockRecordDto>>> getAllPageable(@RequestParam(required = false, defaultValue = "0") @Min(0) Integer pageNum,
                                                                            @RequestParam(required = false, defaultValue = "20") @Min(1) Integer pageSize,
                                                                            @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                                            @RequestParam(required = false, defaultValue = "ASC") String sortDir) {
        return ResponseEntity.ok(dockRecordServiceFacade.getAllPageable(new PageRequest(pageNum, pageSize, sortBy, sortDir)));
    }

    @PutMapping
    public ResponseEntity<DockRecordDto> update(@RequestBody @Valid DockRecordDto dockRecordDto) {
        return ResponseEntity.ok(dockRecordServiceFacade.update(dockRecordDto));
    }
}
