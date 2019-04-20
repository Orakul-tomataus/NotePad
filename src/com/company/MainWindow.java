package com.company;

        import javax.swing.*;
        import java.awt.*;
        import java.io.File;
        import java.io.FileReader;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.util.Properties;

class MainWindow extends JFrame
{


    MainWindow(){
        super("Text Editor");

        JTabbedPane tabs = new JTabbedPane();
        MyListener myListener = new MyListener(tabs);
        Config config = new Config("config.properties");

        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menu = new JMenuBar();

        menu.add(new Files(tabs));
        menu.add(new Settings(tabs));
        setJMenuBar(menu);
        add(tabs);
        tabs.addKeyListener(myListener.getKeyadapter());
    }

}