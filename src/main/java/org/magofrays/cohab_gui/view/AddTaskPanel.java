package org.magofrays.cohab_gui.view;

import javax.swing.*;

import org.magofrays.cohab_gui.model.dto.Priority;
import org.magofrays.cohab_gui.model.dto.Task;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AddTaskPanel extends RoundedPanel {
    private JTextField titleField;
    private JTextArea descriptionArea;
    private JComboBox<String> assignedToComboBox;
    private JComboBox<Priority> priorityComboBox;
    private JSpinner deadlineSpinner;
    private Map<String, UUID> userMap; // Для хранения соответствия имени пользователя и его UUID

    public AddTaskPanel() {
        initializeUserMap();
        initializeComponents();
        setupLayout();
    }

    private void initializeUserMap() {
        // Здесь можно загрузить реальных пользователей из базы данных
        userMap = new HashMap<>();
        userMap.put("Иван Иванов", UUID.randomUUID());
        userMap.put("Петр Петров", UUID.randomUUID());
        userMap.put("Мария Сидорова", UUID.randomUUID());
        userMap.put("Алексей Козлов", UUID.randomUUID());
    }

    private void initializeComponents() {
        // Поле для заголовка
        titleField = new JTextField(20);

        // Поле для описания
        descriptionArea = new JTextArea(4, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);

        // Выпадающий список для выбора пользователя
        assignedToComboBox = new JComboBox<>();
        for (String userName : userMap.keySet()) {
            assignedToComboBox.addItem(userName);
        }

        // Выпадающий список для приоритета
        priorityComboBox = new JComboBox<>(Priority.values());

        // Спиннер для выбора даты и времени
        SpinnerDateModel dateModel = new SpinnerDateModel();
        deadlineSpinner = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(deadlineSpinner, "dd.MM.yyyy HH:mm");
        deadlineSpinner.setEditor(dateEditor);
        deadlineSpinner.setValue(java.util.Calendar.getInstance().getTime()); // Установка текущей даты
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Заголовок
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Заголовок:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(titleField, gbc);

        // Описание
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(new JLabel("Описание:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        JScrollPane descriptionScroll = new JScrollPane(descriptionArea);
        descriptionScroll.setPreferredSize(new Dimension(200, 80));
        add(descriptionScroll, gbc);

        // Назначить
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(new JLabel("Назначить:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(assignedToComboBox, gbc);

        // Приоритет
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(new JLabel("Приоритет:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(priorityComboBox, gbc);

        // Дедлайн
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(new JLabel("Дедлайн:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(deadlineSpinner, gbc);

        // Кнопка добавления
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton addButton = new JButton("Добавить задачу");
        addButton.addActionListener(e -> addTask());
        add(addButton, gbc);
    }

    public Task getTask() {
        String title = titleField.getText().trim();
        String description = descriptionArea.getText().trim();

        if (title.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Введите заголовок задачи", "Ошибка", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        String selectedUserName = (String) assignedToComboBox.getSelectedItem();
        UUID assignedTo = userMap.get(selectedUserName);

        java.util.Date date = (java.util.Date) deadlineSpinner.getValue();
        LocalDateTime deadline = LocalDateTime.ofInstant(date.toInstant(), java.time.ZoneId.systemDefault());

        Priority priority = (Priority) priorityComboBox.getSelectedItem();

        return Task.builder()
                .title(title)
                .description(description)
                .deadline(deadline)
                .assignedTo(assignedTo)
                .priority(priority)
                .build();
    }

    private void addTask() {
        Task task = getTask();
        if (task != null) {
            // Здесь можно добавить логику сохранения задачи
            JOptionPane.showMessageDialog(this, "Задача успешно добавлена!", "Успех", JOptionPane.INFORMATION_MESSAGE);
            clearForm();
        }
    }

    private void clearForm() {
        titleField.setText("");
        descriptionArea.setText("");
        assignedToComboBox.setSelectedIndex(0);
        priorityComboBox.setSelectedIndex(0);
        deadlineSpinner.setValue(java.util.Calendar.getInstance().getTime());
    }

    public void addUser(String userName, UUID userId) {
        userMap.put(userName, userId);
        assignedToComboBox.addItem(userName);
    }

    public void removeUser(String userName) {
        userMap.remove(userName);
        assignedToComboBox.removeItem(userName);
    }
}