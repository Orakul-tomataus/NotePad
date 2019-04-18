package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Settings extends JMenu
{
    Settings(JTabbedPane tabs){
        super("Settings");
        Actions actions = new Actions(tabs);
        JMenuItem size = new JMenuItem("size");
        size.addActionListener(actionEvent -> actions.selectSize());
        this.add(size);
    }
}
