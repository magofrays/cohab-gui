package org.magofrays.cohab_gui.view;

import org.magofrays.cohab_gui.model.Member;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class MemberPanel extends JPanel {

    private final Member member;
    private JLabel username;
    private JLabel firstname;
    private JLabel lastname;
    private JLabel birthDate;

    public MemberPanel(Member member){
        this.member = member;
        initComponents();
    }

    private void initComponents(){
        username = new JLabel(member.getUsername());
        firstname = new JLabel(member.getFirstname());
        lastname = new JLabel(member.getLastname());
        birthDate = new JLabel(member.getBirthDate().format(DateTimeFormatter.ISO_DATE));

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // Панель для основной информации
        JPanel infoPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        infoPanel.add(new JLabel("Username:"));
        infoPanel.add(username);
        infoPanel.add(new JLabel("First Name:"));
        infoPanel.add(firstname);
        infoPanel.add(new JLabel("Last Name:"));
        infoPanel.add(lastname);

        // Панель для даты рождения
        JPanel birthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        birthPanel.add(new JLabel("Birth Date:"));
        birthPanel.add(birthDate);

        // Компоновка
        add(infoPanel, BorderLayout.CENTER);
        add(birthPanel, BorderLayout.SOUTH);

        // Устанавливаем отступы
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
    }

    // Метод для обновления данных, если member изменится
    public void updateMemberInfo() {
        username.setText(member.getUsername());
        firstname.setText(member.getFirstname());
        lastname.setText(member.getLastname());
        birthDate.setText(member.getBirthDate().format(DateTimeFormatter.ISO_DATE));
    }
}