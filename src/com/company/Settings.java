package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Settings extends JMenu
{
    Settings(){
        super("Settings");

        JMenuItem size = new JMenuItem("size");
        size.addActionListener(actionEvent -> {

        });
        this.add(size);
    }
}
