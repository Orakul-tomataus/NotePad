package com.company;

import javax.swing.*;

class MainWindow extends JFrame
{


    MainWindow(){
        super("Text Editor");

        JTabbedPane tabs = new JTabbedPane();
        MyListener myListener = new MyListener(tabs);

        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menu = new JMenuBar();

        menu.add(new File(tabs));
        menu.add(new Settings());
        setJMenuBar(menu);

        add(tabs);

        tabs.addKeyListener(myListener.getKeyadapter());
    }
}