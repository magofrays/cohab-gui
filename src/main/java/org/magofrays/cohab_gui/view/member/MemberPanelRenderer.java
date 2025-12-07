package org.magofrays.cohab_gui.view.member;

import org.magofrays.cohab_gui.model.dto.member.Member;

import javax.swing.*;
import java.awt.*;

public class MemberPanelRenderer implements ListCellRenderer<Member> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Member> list,
                                                  Member member,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {

        MemberPanel memberPanel = new MemberPanel(member);

        if (isSelected) {
            memberPanel.setBackground(list.getSelectionBackground());
            memberPanel.setForeground(list.getSelectionForeground());
        } else {
            memberPanel.setBackground(list.getBackground());
            memberPanel.setForeground(list.getForeground());
        }

        memberPanel.setEnabled(list.isEnabled());
        memberPanel.setFont(list.getFont());
        memberPanel.setOpaque(true);

        if (cellHasFocus) {
            memberPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        } else {
            memberPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        }

        return memberPanel;
    }
}