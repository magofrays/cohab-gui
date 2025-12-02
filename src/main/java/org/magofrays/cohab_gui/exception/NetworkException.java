package org.magofrays.cohab_gui.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NetworkException extends Throwable {
	private String message = "Проблема с соединением. Либо лежит сервер, либо у вас все плохо с интернетом.";
	public NetworkException(String message) {
		this.message = message;
	}
}
