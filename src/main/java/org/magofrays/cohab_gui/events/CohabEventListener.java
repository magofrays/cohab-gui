package org.magofrays.cohab_gui.events;

import java.util.EventListener;
import java.util.EventObject;

public interface CohabEventListener extends EventListener {
    void processEvent(EventObject event);
}
