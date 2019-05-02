package com.company;

import javax.swing.*;
import java.awt.*;

 class Tab {
    private final JTabbedPane tabs;

    Tab(JTabbedPane tabs){
        this.tabs = tabs;
    }
    void createTabs(String context,String name)
    {
        JTextArea text = new JTextArea(context);
        Scroll scroll = new Scroll(text,name);
        tabs.addTab(name,scroll);
        int id = tabs.getTabCount();
        id -= 1;
        JPanel pnlTab = new JPanel(new BorderLayout());
        pnlTab.setOpaque(false);
        JLabel lblTitle = new JLabel(name);
        JButton btnClose = new JButton("x");
        pnlTab.add(lblTitle,BorderLayout.WEST);
        pnlTab.add(btnClose,BorderLayout.EAST);
        tabs.setTabComponentAt(id, pnlTab);
        btnClose.addActionListener(actionEvent -> {
            Component selected = tabs.getSelectedComponent();
            if (selected != null) {
                tabs.remove(selected);
            }
        });

    }
}
