package org.magofrays.cohab_gui.controller;

import lombok.RequiredArgsConstructor;
import org.magofrays.cohab_gui.events.CohabEventListener;
import org.magofrays.cohab_gui.model.MemberBarModel;
import org.magofrays.cohab_gui.view.member.MemberBarPanel;
import org.springframework.stereotype.Component;

import java.util.EventObject;

@Component
@RequiredArgsConstructor
public class MemberController implements CohabEventListener {
    private final MemberBarModel model;
    private final MemberBarPanel panel;


    @Override
    public void processEvent(EventObject event) {

    }
}
