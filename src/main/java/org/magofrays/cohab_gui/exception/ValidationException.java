package org.magofrays.cohab_gui.exception;

import org.magofrays.cohab_gui.model.dto.ValidationErrorResponse;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException{
	ValidationErrorResponse body;
	public ValidationException(ValidationErrorResponse body) {
		this.body = body;
	}
}
