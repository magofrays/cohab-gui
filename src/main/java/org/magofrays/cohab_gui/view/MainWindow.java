package org.magofrays.cohab_gui.view;
import java.time.LocalDateTime;

import javax.swing.JFrame;

import org.magofrays.cohab_gui.model.Task;

public class MainWindow extends JFrame
{
	TaskbarWindow taskbarWindow;
	
	public MainWindow(String info) {
		super(info);
		this.taskbarWindow = new TaskbarWindow();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); 
        addTestTasks();
	}
	
    
    private void addTestTasks() {
        Task task1 = Task.builder().title("Сделать презентацию").deadline( 
            LocalDateTime.now().plusDays(2)).build();
        Task task2 = Task.builder().title("Купить продукты").deadline( 
            LocalDateTime.now().plusDays(1)).build();
        Task task3 = Task.builder().title("Записаться к врачу").deadline(
            LocalDateTime.now().minusDays(1)).build();
       
        taskbarWindow.addTaskComponent(new TaskComponent(task1));
        taskbarWindow.addTaskComponent(new TaskComponent(task2));
        taskbarWindow.addTaskComponent(new TaskComponent(task3));
    }
	
}
