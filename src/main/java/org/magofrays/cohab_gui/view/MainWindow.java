package org.magofrays.cohab_gui.view;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.*;

import org.magofrays.cohab_gui.model.Member;
import org.magofrays.cohab_gui.model.Task;

public class MainWindow extends JFrame
{
	TaskbarPanel taskbarPanel;
    FamilyMemberPanel familyMemberPanel;
	
	public MainWindow(String info) {
		super(info);
        setLayout(new BorderLayout(5, 5));
		this.taskbarPanel = new TaskbarPanel();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        getContentPane().setBackground(new Color(186, 111, 186));
        addTestTasks();
        JPanel wrapper = new JPanel();
        wrapper.setBackground(new Color(186, 111, 186));
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        wrapper.add(taskbarPanel);
        wrapper.add(Box.createVerticalGlue());
        this.familyMemberPanel = new FamilyMemberPanel();
        wrapper.add(familyMemberPanel);
        wrapper.add(Box.createVerticalGlue());
        this.add(wrapper, BorderLayout.WEST);
        addMemberTest();
        setVisible(true);
	}
	
    private void addMemberTest(){
        Member member1 = Member.builder().username("magofrays").firstname("Vadim")
                .birthDate(LocalDate.of(2005, 3, 28))
                .build();
        familyMemberPanel.addMemberPanel(new MemberPanel(member1));
    }


    private void addTestTasks() {
        Task task1 = Task.builder().title("Сделать презентацию").created(LocalDateTime.now()).deadline(
            LocalDateTime.now().plusDays(2)).checked(false).signedForCheck(false).build();
        Task task2 = Task.builder().title("Купить продукты").created(LocalDateTime.now()).checked(false).signedForCheck(true).deadline(
            LocalDateTime.now().plusDays(1)).build();
        Task task3 = Task.builder().title("Записаться к врачу").created(LocalDateTime.now()).deadline(
            LocalDateTime.now().minusDays(1)).checked(true).signedForCheck(true).build();
        taskbarPanel.addTaskComponent(new TaskPanel(task1));
        taskbarPanel.addTaskComponent(new TaskPanel(task2));
        taskbarPanel.addTaskComponent(new TaskPanel(task3));
        taskbarPanel.addTaskComponent(new TaskPanel(task1));
        taskbarPanel.addTaskComponent(new TaskPanel(task1));
        taskbarPanel.addTaskComponent(new TaskPanel(task2));
        taskbarPanel.addTaskComponent(new TaskPanel(task3));
        taskbarPanel.addTaskComponent(new TaskPanel(task1));

    }
	
}
