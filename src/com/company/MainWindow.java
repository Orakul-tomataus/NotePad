package com.company;

        import javax.swing.*;

class MainWindow extends JFrame
{
    static Config config;

    MainWindow(){
        super("Text Editor");

        JTabbedPane tabs = new JTabbedPane();
        config = new Config("config.properties");
        Actions actions = new Actions(tabs);
        MyListener myListener = new MyListener(actions);

        Scroll.myListener = myListener;





        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menu = new JMenuBar();

        menu.add(new Files(actions));
        menu.add(new Settings(actions));

        setJMenuBar(menu);
        add(tabs);
        tabs.addKeyListener(myListener.getKeyadapter());
    }

}