package com.company;

import javax.swing.*;

class Settings extends JMenu
{
    Settings(Actions actions){
        super("Settings");
        JMenuItem size = new JMenuItem("size");
        size.addActionListener(actionEvent -> actions.selectSize());
        this.add(size);
    }
}
