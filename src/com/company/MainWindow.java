package com.company;

        import javax.swing.*;

class MainWindow extends JFrame
{
    static Config config;
    static MyListener Listeners;

    MainWindow(){
        super("Text Editor");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();
        config = new Config("config.properties");
        Actions actions = new Actions(tabs);
        Listeners = new MyListener(actions);

        JMenuBar menu = new JMenuBar();
        menu.add(new Files(actions));
        menu.add(new Settings(actions));

        setJMenuBar(menu);
        add(tabs);
        tabs.addKeyListener(Listeners.getKeyadapter());
    }

}