package org.magofrays.cohab_gui.model;

import javax.swing.DefaultListModel;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListDataListener;

import org.magofrays.cohab_gui.events.CohabEventListener;
import org.magofrays.cohab_gui.events.MemberEvent;
import org.magofrays.cohab_gui.model.dto.member.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.UUID;


@Component
public class MemberBarModel extends DefaultListModel<Member> {

}
