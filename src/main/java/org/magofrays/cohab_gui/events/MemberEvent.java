package org.magofrays.cohab_gui.events;

import java.util.EventObject;

public class MemberEvent extends EventObject {

    MemberEventType type;


    public MemberEvent(Object source, MemberEventType eventType) {
        super(source);
        this.type = eventType;
    }
}
