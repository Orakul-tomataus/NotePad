package com.company;

import javax.swing.*;

class Files extends JMenu
{
    Files(Actions actions){
        super("File");
        
        JMenuItem new_file = new JMenuItem("New File");
        JMenuItem open_file = new JMenuItem("Open File");
        JMenuItem save_file = new JMenuItem("Save File");

        new_file.addActionListener(actionEvent -> actions.new_file());
        open_file.addActionListener(actionEvent -> actions.open_file());
        save_file.addActionListener(actionEvent -> actions.save_file());
        this.add(new_file);
        this.add(open_file);
        this.add(save_file);
    }
}
