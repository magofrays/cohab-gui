package org.magofrays.cohab_gui.view;
import java.awt.*;
import java.time.LocalDateTime;

import javax.swing.*;

import org.magofrays.cohab_gui.model.Task;

public class MainWindow extends JFrame
{
	TaskbarWindow taskbarWindow;
	
	public MainWindow(String info) {
		super(info);
		this.taskbarWindow = new TaskbarWindow();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(184, 172, 172));
        setResizable(false);
        setVisible(true);
        addTestTasks();
        this.add(taskbarWindow);
	}
	
    
    private void addTestTasks() {
        Task task1 = Task.builder().title("Сделать презентацию").created(LocalDateTime.now()).deadline(
            LocalDateTime.now().plusDays(2)).checked(false).signedForCheck(false).build();
        Task task2 = Task.builder().title("Купить продукты").created(LocalDateTime.now()).checked(false).signedForCheck(true).deadline(
            LocalDateTime.now().plusDays(1)).build();
        Task task3 = Task.builder().title("Записаться к врачу").created(LocalDateTime.now()).deadline(
            LocalDateTime.now().minusDays(1)).checked(true).signedForCheck(true).build();
       
        taskbarWindow.addTaskComponent(new TaskComponent(task1));
        taskbarWindow.addTaskComponent(new TaskComponent(task2));
        taskbarWindow.addTaskComponent(new TaskComponent(task3));
    }
	
}
