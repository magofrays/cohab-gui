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

public class TaskbarWindow extends JPanel {
    private static final long serialVersionUID = -4327288042877312792L;
	private JPanel tasksContainer;
    private List<TaskComponent> taskComponents;
    
    public TaskbarWindow() {
        taskComponents = new ArrayList<>();
        initializeComponents();
        setVisible(true);
    }
    
    private void initializeComponents() {
        setLayout(new BorderLayout());
        
        tasksContainer = new JPanel();
        tasksContainer.setLayout(new BoxLayout(tasksContainer, BoxLayout.Y_AXIS));
        tasksContainer.setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(tasksContainer);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        add(scrollPane, BorderLayout.CENTER);
    }
    
    public void addTaskComponent(TaskComponent taskComponent) {
        taskComponents.add(taskComponent);
        tasksContainer.add(taskComponent);
        
        if (taskComponents.size() > 1) {
            tasksContainer.add(createSeparator());
        }
        
        refreshLayout();
    }
    
    public void removeTaskComponent(TaskComponent taskComponent) {
        taskComponents.remove(taskComponent);
        tasksContainer.remove(taskComponent);
        
        removeSeparators();
        addSeparators();
        
        refreshLayout();
    }
    
    public void clearTasks() {
        taskComponents.clear();
        tasksContainer.removeAll();
        refreshLayout();
    }
    
    public List<TaskComponent> getTaskComponents() {
        return new ArrayList<>(taskComponents);
    }
    
    private JSeparator createSeparator() {
        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        separator.setBackground(Color.LIGHT_GRAY);
        return separator;
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
        for (int i = 0; i < taskComponents.size(); i++) {
            tasksContainer.add(taskComponents.get(i));
            if (i < taskComponents.size() - 1) {
                tasksContainer.add(createSeparator());
            }
        }
    }
    
    private void refreshLayout() {
        tasksContainer.revalidate();
        tasksContainer.repaint();
    }
    
    public void refreshAllComponents() {
        for (TaskComponent tc : taskComponents) {
            tc.updateView();
        }
        refreshLayout();
    }
    
}