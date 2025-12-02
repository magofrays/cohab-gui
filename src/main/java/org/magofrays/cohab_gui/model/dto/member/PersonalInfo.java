package org.magofrays.cohab_gui.model.dto.member;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PersonalInfo {
    private String firstname;
    private String lastname;
    private String patronymic;
    private LocalDate birthDate;
}
