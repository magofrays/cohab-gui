package org.magofrays.cohab_gui.model.dto.auth;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
	private String accessToken;
	private LocalDateTime expiresAccessTokenAt;
	private String refreshToken;
	private LocalDateTime expiresRefreshTokenAt;
}
