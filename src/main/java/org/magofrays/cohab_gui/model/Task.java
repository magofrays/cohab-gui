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
	String title;
	String description;
	LocalDateTime created;
	LocalDateTime deadline;
	Boolean signedForCheck;
	Boolean checked;
	UUID createdBy;
	Priority priority;
}
