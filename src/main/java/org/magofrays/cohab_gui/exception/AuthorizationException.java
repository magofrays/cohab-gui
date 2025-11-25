package org.magofrays.cohab_gui.exception;

public class AuthorizationException extends RuntimeException {
	
	String message;
	
	public AuthorizationException(String message) {
		this.message = message;
	}
}
