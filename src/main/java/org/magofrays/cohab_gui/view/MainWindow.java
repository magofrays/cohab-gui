package org.magofrays.cohab_gui.view;
import java.awt.*;

import javax.swing.*;

import org.magofrays.cohab_gui.view.member.MemberPanel;
import org.springframework.stereotype.Component;

@Component
public class MainWindow extends JFrame
{
    PanelList<TaskPanel> taskbarPanel;
    PanelList<MemberPanel> familyMemberPanel;
    AddTaskPanel addTaskPanel;
	
	public MainWindow() {
		super("приложение");
        setLayout(new BorderLayout(10, 10));
        ((JPanel)this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.taskbarPanel = new PanelList<>("Current tasks:", 400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        getContentPane().setBackground(new Color(0, 123, 186));
        JPanel wrapper = new JPanel();
        wrapper.setBackground(new Color(0, 123, 186));
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        wrapper.add(taskbarPanel);
        wrapper.add(Box.createRigidArea(new Dimension(0, 10)));
        this.familyMemberPanel = new PanelList<>("Family members:", 400, 400);
        wrapper.add(familyMemberPanel);
        this.add(wrapper, BorderLayout.WEST);
        this.addTaskPanel = new AddTaskPanel();
        this.add(addTaskPanel, BorderLayout.EAST);
        setVisible(true);
	}
	




}
