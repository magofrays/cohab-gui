package org.magofrays.cohab_gui.view;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelList<cc extends ContainerComponent> extends RoundedPanel {
    private JLabel title;
    private RoundedPanel container;
    private final List<cc> panelList;
    public PanelList(String title, int width, int height){
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setMaximumSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width, height));
        panelList = new ArrayList<>();
        setLayout(new BorderLayout());
        this.title = new JLabel(title);
        this.title.setHorizontalAlignment(SwingConstants.CENTER);
        this.title.setFont(new Font("Ubuntu Mono", Font.BOLD, 20));
        container = new RoundedPanel();
        container.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.WHITE);
        container.setMaximumSize(new Dimension(400, 400));
        JScrollPane scrollPane = new JScrollPane(container);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        scrollPane.setMaximumSize(new Dimension(400, 400));
        add(this.title, BorderLayout.NORTH);
        add(scrollPane);
    }

    public void addComponent(cc containerComponent){
        panelList.add(containerComponent);
        container.add(containerComponent);
    }

    public PanelList<cc> removeComponent(cc containerComponent){
        panelList.remove(containerComponent);
        container.remove(containerComponent);
        return this;
    }

    private void refreshLayout(){
        container.revalidate();
        container.repaint();
    }
    public PanelList<cc> clearComponents() {
        panelList.clear();
        container.removeAll();
        refreshLayout();
        return this;
    }
}
