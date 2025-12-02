package org.magofrays.cohab_gui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class TaskbarPanel extends JPanel {
	private JPanel tasksContainer;
    private final List<TaskPanel> taskPanels;
    
    public TaskbarPanel() {
        setLayout(new BorderLayout());
        taskPanels = new ArrayList<>();
        initializeComponents();
        setPreferredSize(new Dimension(400, 400));
        setMaximumSize(new Dimension(400, 400));
    }
    
    private void initializeComponents() {
        tasksContainer = new JPanel();
        tasksContainer.setLayout(new BoxLayout(tasksContainer, BoxLayout.Y_AXIS));
        tasksContainer.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(tasksContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setMaximumSize(new Dimension(400, 400));
        add(scrollPane);
    }
    
    public void addTaskComponent(TaskPanel taskPanel) {
        taskPanels.add(taskPanel);
        tasksContainer.add(taskPanel);

        
        refreshLayout();
    }
    
    public void removeTaskComponent(TaskPanel taskPanel) {
        taskPanels.remove(taskPanel);
        tasksContainer.remove(taskPanel);
        refreshLayout();
    }
    
    public void clearTasks() {
        taskPanels.clear();
        tasksContainer.removeAll();
        refreshLayout();
    }
    
    private void removeSeparators() {
        Component[] components = tasksContainer.getComponents();
        for (Component comp : components) {
            if (comp instanceof JSeparator) {
                tasksContainer.remove(comp);
            }
        }
    }
    
    private void addSeparators() {
        for (int i = 0; i < taskPanels.size(); i++) {
            tasksContainer.add(taskPanels.get(i));

        }
    }
    
    private void refreshLayout() {
        tasksContainer.revalidate();
        tasksContainer.repaint();
    }
    
    public void refreshAllComponents() {
        for (TaskPanel tc : taskPanels) {
            tc.updateView();
        }
        refreshLayout();
    }
    
}