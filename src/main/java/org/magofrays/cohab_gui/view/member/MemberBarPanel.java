package org.magofrays.cohab_gui.view.member;

import org.magofrays.cohab_gui.model.MemberBarModel;
import org.magofrays.cohab_gui.model.dto.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MemberBarPanel extends JPanel {

    JList<Member> memberPanels;
    JPanel memberContainer;

    public MemberBarPanel(@Autowired MemberBarModel model){
        setLayout(new BorderLayout());
        memberPanels = new JList<>(model);
        memberPanels.setCellRenderer(new MemberPanelRenderer());
        memberContainer = new JPanel();
        memberContainer.setLayout(new BoxLayout(memberContainer, BoxLayout.Y_AXIS));
        memberContainer.setBackground(Color.WHITE);
        memberContainer.setMaximumSize(new Dimension(400, 400));
        memberContainer.add(memberPanels);
        JScrollPane scrollPane = new JScrollPane(memberContainer);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setMaximumSize(new Dimension(400, 400));
        add(scrollPane);
    }

    private void refreshLayout(){
        memberContainer.revalidate();
        memberContainer.repaint();
    }
}
