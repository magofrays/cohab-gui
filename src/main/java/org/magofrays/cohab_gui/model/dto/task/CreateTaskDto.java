package org.magofrays.cohab_gui.model.dto.task;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class CreateTaskDto {
    private String title;
    private String description;
    private LocalDateTime deadline;
    private UUID createdBy;
    private UUID assignedTo;
    private Priority priority;
}
