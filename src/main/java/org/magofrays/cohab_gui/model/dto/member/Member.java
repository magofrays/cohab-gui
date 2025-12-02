package org.magofrays.cohab_gui.model.dto.member;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Member {
	private UUID id;
    private String username;
    private PersonalInfo personalInfo;
}
