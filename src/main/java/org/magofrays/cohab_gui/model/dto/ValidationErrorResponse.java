package org.magofrays.cohab_gui.model.dto;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
public class ValidationErrorResponse {
    
	@Data
	@RequiredArgsConstructor
	public static class Violation{
    	private final String fieldName;
    	private final String message;
    }
	
    private final List<Violation> violations;
}
    
