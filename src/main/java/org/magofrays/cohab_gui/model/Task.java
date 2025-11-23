package org.magofrays.cohab_gui.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
	private String title;
	private String description;
	private LocalDateTime created;
	private LocalDateTime deadline;
	private Boolean signedForCheck;
	private Boolean checked;
	private UUID createdBy;
	private Priority priority;
}
