package org.magofrays.cohab_gui.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class LoginResponse {
	private String accessToken;
	private LocalDateTime expiresAccessTokenAt;
	private String refreshToken;
	private LocalDateTime expiresRefreshTokenAt;
}
