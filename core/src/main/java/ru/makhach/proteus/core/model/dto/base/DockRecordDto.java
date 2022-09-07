package ru.makhach.proteus.core.model.dto.base;

import ru.makhach.proteus.core.validation.Marker;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class DockRecordDto {
    @Null(groups = Marker.Create.class)
    @NotNull(groups = Marker.Update.class)
    @Min(value = 1, groups = Marker.Update.class)
    private final Long id;
    @Null
    private final Long dockingTime;
    private final Boolean isUndocked;
    @Null
    private final Long undockedTime;
    @Min(1)
    @NotNull
    private final Long dockId;
    @Min(1)
    @NotNull
    private final Long vesselId;

    private DockRecordDto(Builder builder) {
        this.id = builder.id;
        this.dockingTime = builder.dockingTime;
        this.isUndocked = builder.isUndocked;
        this.undockedTime = builder.undockedTime;
        this.dockId = builder.dockId;
        this.vesselId = builder.vesselId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public Long getDockingTime() {
        return dockingTime;
    }

    public Boolean getUndocked() {
        return isUndocked;
    }

    public Long getUndockedTime() {
        return undockedTime;
    }

    public Long getDockId() {
        return dockId;
    }

    public Long getVesselId() {
        return vesselId;
    }

    public static class Builder {
        private Long id;
        private Long dockingTime;
        private Boolean isUndocked;
        private Long undockedTime;
        private Long dockId;
        private Long vesselId;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder dockingTime(Long dockingTime) {
            this.dockingTime = dockingTime;
            return this;
        }

        public Builder isUndocked(Boolean isUndocked) {
            this.isUndocked = isUndocked;
            return this;
        }

        public Builder undockedTime(Long undockedTime) {
            this.undockedTime = undockedTime;
            return this;
        }

        public Builder dockId(Long dockId) {
            this.dockId = dockId;
            return this;
        }

        public Builder vesselId(Long vesselId) {
            this.vesselId = vesselId;
            return this;
        }

        public DockRecordDto build() {
            return new DockRecordDto(this);
        }
    }
}
