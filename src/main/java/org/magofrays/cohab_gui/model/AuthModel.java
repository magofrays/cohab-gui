package org.magofrays.cohab_gui.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.magofrays.cohab_gui.model.dto.auth.JwtToken;
import org.magofrays.cohab_gui.model.dto.auth.LoginResponse;
import org.magofrays.cohab_gui.model.dto.member.Member;
import org.springframework.stereotype.Component;

import lombok.Getter;


@Component
public class AuthModel{
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	@Getter
	private JwtToken accessToken;
	@Getter
	private JwtToken refreshToken;	
	@Getter
	private Member credentials;
	
	public void setCredentials(Member credentials) {
		var oldCredentials = this.credentials;
		this.credentials = credentials;
		pcs.firePropertyChange("credentials", oldCredentials, credentials);
	}
	
	public void setAuth(JwtToken auth) {
		var oldToken = this.accessToken;
		this.accessToken = auth;
		
		pcs.firePropertyChange("accessToken", oldToken, accessToken);
	}
	
	public void setAuth(LoginResponse auth) {
		var oldAccessToken = this.accessToken;
		accessToken = JwtToken.builder()
				.token(auth.getAccessToken())
				.expiresAt(auth.getExpiresAccessTokenAt())
				.build();
		pcs.firePropertyChange("accessToken", oldAccessToken, accessToken);
		var oldRefreshToken = this.refreshToken;
		refreshToken = JwtToken.builder()
				.token(auth.getRefreshToken())
				.expiresAt(auth.getExpiresRefreshTokenAt())
				.build();
		pcs.firePropertyChange("accessToken", oldRefreshToken, refreshToken);
	}
	public void addListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}
	
}

