package org.magofrays.cohab_gui.view;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import org.magofrays.cohab_gui.model.dto.task.Task;



public class TaskPanel extends ContainerComponent {
	Task task;
	JLabel titleLabel;
	JLabel descrLabel;
	JLabel createdLabel;
	JProgressBar timeProgressBar;
	JCheckBox signForCheck;
	JCheckBox checked;
	JLabel endLabel;
		
	public TaskPanel(Task task) {
        this.task = task;
        initializeComponents();
        setupLayout();
        updateView();
        setMaximumSize(new Dimension(400, 100));
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    
    private void initializeComponents() {
        titleLabel = new JLabel();
        titleLabel.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        endLabel = new JLabel();
        endLabel.setFont(new Font("Ubuntu Mono", Font.PLAIN, 15));
        endLabel.setForeground(new Color(123, 245, 255));
       
        timeProgressBar = new JProgressBar(0, 100);
        timeProgressBar.setPreferredSize(new Dimension(80, 12));
        timeProgressBar.setStringPainted(true);

        signForCheck = new JCheckBox();
//        signForCheck.addActionListener(e -> onCompletionToggle());
        checked = new JCheckBox();
//        checked.addActionListener(e -> onCheckedToggle());
        this.add(titleLabel);
        this.add(endLabel);
        this.add(timeProgressBar);
        this.add(signForCheck);
        this.add(checked);
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));

        JPanel leftPanel = new JPanel(new BorderLayout(8, 0));
        JPanel checkboxesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        checkboxesPanel.add(signForCheck);
        checkboxesPanel.add(checked);
        leftPanel.add(checkboxesPanel, BorderLayout.WEST);
        leftPanel.add(titleLabel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        rightPanel.add(timeProgressBar);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(leftPanel, BorderLayout.WEST);
        topPanel.add(rightPanel, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 2));
        bottomPanel.add(endLabel);
        
        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    public void updateView() {
        titleLabel.setText(task.getTitle());
        
        if (task.getChecked()) {
            titleLabel.setText("<html><strike>" + task.getTitle() + "</strike></html>");
        }
        
        if (task.getDeadline() != null) {
            String deadline = "До: " + task.getDeadline().format(
                DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            endLabel.setText(deadline);
            
            if (LocalDateTime.now().isAfter(task.getDeadline())) {
                endLabel.setForeground(Color.RED);
            }
        }
        
        updateProgressBar();
        
//        signForCheck.setSelected(task.isCompleted());
        // checked.setSelected(...); // TODO: добавьте логику для второго чекбокса
    }
    
    private void updateProgressBar() {
        if (task.getDeadline() == null || task.getCreated() == null) {
            timeProgressBar.setValue(0);
            timeProgressBar.setString("Нет срока");
            return;
        }
        
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime created = task.getCreated();
        LocalDateTime deadline = task.getDeadline();
        
        if (now.isAfter(deadline)) {
            timeProgressBar.setValue(100);
            timeProgressBar.setString("Просрочено!");
            timeProgressBar.setForeground(Color.RED);
            return;
        }
        
        
        long totalDuration = ChronoUnit.MINUTES.between(created, deadline);
        long elapsedDuration = ChronoUnit.MINUTES.between(created, now);
        
        int progress = (int) ((elapsedDuration * 100) / totalDuration);
        progress = Math.max(0, Math.min(100, progress));
        
        timeProgressBar.setValue(progress);
        timeProgressBar.setString(progress + "%");
        
        if (progress > 80) {
            timeProgressBar.setForeground(Color.RED);
        } else if (progress > 60) {
            timeProgressBar.setForeground(Color.ORANGE);
        } else {
            timeProgressBar.setForeground(Color.GREEN);
        }
    }
    
    private void onCompletionToggle() {
//        task.setCompleted(signForCheck.isSelected());
        updateView();
    }
    
    private void onCheckedToggle() {
        // TODO: добавьте логику для второго чекбокса
        System.out.println("Second checkbox toggled");
    }

}
