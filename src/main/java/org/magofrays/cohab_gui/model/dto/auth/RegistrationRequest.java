package org.magofrays.cohab_gui.model.dto.auth;

import lombok.Builder;
import lombok.Data;
import org.magofrays.cohab_gui.model.dto.member.PersonalInfo;

import java.util.UUID;

@Data
@Builder
public class RegistrationRequest {
    private String username;
    private String email;
    private String password;
    private PersonalInfo personalInfo;
}
