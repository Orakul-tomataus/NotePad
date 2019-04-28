package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyCloseActionHandler implements ActionListener {
    private JTabbedPane tabPane;
    MyCloseActionHandler(JTabbedPane tabbedPane){
        this.tabPane = tabbedPane;
    }

    public void actionPerformed(ActionEvent evt) {

        Component selected = tabPane.getSelectedComponent();
        if (selected != null) {
            tabPane.remove(selected);
        }

    }

}
