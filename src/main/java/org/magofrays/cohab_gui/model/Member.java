package org.magofrays.cohab_gui.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class Member {
    private String username;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
}
