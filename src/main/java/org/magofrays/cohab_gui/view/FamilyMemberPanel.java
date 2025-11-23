package org.magofrays.cohab_gui.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyMemberPanel extends JPanel {
    List<MemberPanel> memberPanels;
    JPanel memberContainer;
    public FamilyMemberPanel(){
        setLayout(new BorderLayout());
        memberPanels = new ArrayList<>();
        memberContainer = new JPanel();
        memberContainer.setLayout(new BoxLayout(memberContainer, BoxLayout.Y_AXIS));
        memberContainer.setBackground(Color.WHITE);
        memberContainer.setMaximumSize(new Dimension(400, 400));
        JScrollPane scrollPane = new JScrollPane(memberContainer);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setMaximumSize(new Dimension(400, 400));
        add(scrollPane);
    }

    public void addMemberPanel(MemberPanel memberPanel) {
        memberPanels.add(memberPanel);
        memberContainer.add(memberPanel);
        refreshLayout();
    }

    private void refreshLayout(){
        memberContainer.revalidate();
        memberContainer.repaint();
    }
}
