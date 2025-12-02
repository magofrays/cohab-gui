package org.magofrays.cohab_gui.model;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;



@Data
@Component
@RequiredArgsConstructor
public class AppModel {
	private final TaskBarModel taskbarModel;
	private final MemberBarModel memberbarModel;
	private final AuthModel authModel;
}
