package org.magofrays.cohab_gui.controller;

import org.magofrays.cohab_gui.model.AuthModel;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthController {
	private final AuthModel model;
}
