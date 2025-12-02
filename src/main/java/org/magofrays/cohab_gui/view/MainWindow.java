package org.magofrays.cohab_gui.view;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.*;

import org.magofrays.cohab_gui.model.dto.Member;
import org.magofrays.cohab_gui.model.dto.Task;
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
//        setUndecorated(true);
        ((JPanel)this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.taskbarPanel = new PanelList<>("Current tasks:", 400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        getContentPane().setBackground(new Color(0, 123, 186));
        addTestTasks();
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
        addMemberTest();
        setVisible(true);
	}
	
    private void addMemberTest(){
        Member member1 = Member.builder().username("magofrays").firstname("Vadim")
                .birthDate(LocalDate.of(2005, 3, 28))
                .build();
        familyMemberPanel.addComponent(new MemberPanel(member1));
    }


    private void addTestTasks() {
        Task task1 = Task.builder().title("Сделать презентацию").created(LocalDateTime.now()).deadline(
            LocalDateTime.now().plusDays(2)).checked(false).signedForCheck(false).build();
        Task task2 = Task.builder().title("Купить продукты").created(LocalDateTime.now()).checked(false).signedForCheck(true).deadline(
            LocalDateTime.now().plusDays(1)).build();
        Task task3 = Task.builder().title("Записаться к врачу").created(LocalDateTime.now()).deadline(
            LocalDateTime.now().minusDays(1)).checked(true).signedForCheck(true).build();
        taskbarPanel.addComponent(new TaskPanel(task1));
        taskbarPanel.addComponent(new TaskPanel(task2));
        taskbarPanel.addComponent(new TaskPanel(task3));
        taskbarPanel.addComponent(new TaskPanel(task1));
        taskbarPanel.addComponent(new TaskPanel(task1));
        taskbarPanel.addComponent(new TaskPanel(task2));
        taskbarPanel.addComponent(new TaskPanel(task3));
        taskbarPanel.addComponent(new TaskPanel(task1));

    }
	
}
