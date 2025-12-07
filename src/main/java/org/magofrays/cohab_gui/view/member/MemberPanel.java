package org.magofrays.cohab_gui.view.member;

import javax.swing.*;

import org.magofrays.cohab_gui.model.dto.member.Member;
import org.magofrays.cohab_gui.view.ContainerComponent;

import java.awt.*;
import java.time.format.DateTimeFormatter;

public class MemberPanel extends ContainerComponent {

    private final Member member;
    private JLabel username;
    private JLabel firstname;
    private JLabel lastname;
    private JLabel patronymic;
    private JLabel birthDate;
    // todo : настройки по управлению

    public MemberPanel(Member member){
        this.member = member;
        initComponents();
        setMaximumSize(new Dimension(400, 100));
    }

    private void initComponents(){
        username = new JLabel(member.getUsername());
        firstname = new JLabel(member.getPersonalInfo().getFirstname());
        lastname = new JLabel(member.getPersonalInfo().getLastname());
        patronymic = new JLabel(member.getPersonalInfo().getPatronymic());
        birthDate = new JLabel(member.getPersonalInfo().getBirthDate().format(DateTimeFormatter.ISO_DATE));

        setLayout(new BorderLayout());
        JPanel infoPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        infoPanel.add(new JLabel("Никнейм:"));
        infoPanel.add(username);
        infoPanel.add(new JLabel("Имя:"));
        infoPanel.add(firstname);
        infoPanel.add(new JLabel("Фамилия:"));
        infoPanel.add(lastname);
        infoPanel.add(new JLabel("Отчество:"));
        infoPanel.add(lastname);

        JPanel birthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        birthPanel.add(new JLabel("День рождения:"));
        birthPanel.add(birthDate);

        add(infoPanel, BorderLayout.CENTER);
        add(birthPanel, BorderLayout.SOUTH);

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
    }

    public void updateMemberInfo(Member member) {
        username.setText(member.getUsername());
        firstname.setText(member.getPersonalInfo().getFirstname());
        lastname.setText(member.getPersonalInfo().getLastname());
        patronymic.setText(member.getPersonalInfo().getPatronymic());
        birthDate.setText(member.getPersonalInfo().getBirthDate().format(DateTimeFormatter.ISO_DATE));
    }
}