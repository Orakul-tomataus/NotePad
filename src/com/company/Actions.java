package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class Actions
{
    private final Object[] possibilities = {10,15,20,30,40,50,100};
    private JFileChooser f;
    private JTabbedPane tabs;
    private Tab tab;

    Actions(JTabbedPane tabs){
        f = new JFileChooser();
        this.tabs = tabs;
        this.tab = new Tab(tabs);
    }

    void new_file()
    {
        tab.createTabs("","New file");
    }


    void save_file()
    {
        Scroll selectedComponent = (Scroll)tabs.getSelectedComponent();
        if (selectedComponent == null) return;
        f.showSaveDialog(null);
        File file = f.getSelectedFile();
        if (file == null) return;

        selectedComponent.setEditable(false);
        fileWrite(file,selectedComponent);
        selectedComponent.setEditable(true);
    }
    private void fileWrite(File file,Scroll scroll){
        try(FileWriter writer = new FileWriter(file,false)){
            writer.write(scroll.getText());
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    void open_file()
    {
        f.showOpenDialog(null);
        File file = f.getSelectedFile();
        if (file == null) return;
        tab.createTabs("",file.getName());
        Scroll scroll = (Scroll) tabs.getComponentAt(tabs.getTabCount() - 1);
        fileRead(file,scroll);
    }

    private void fileRead(File file,Scroll scroll){
        try {
            Scanner scan = new Scanner(new FileReader(file));
            while(scan.hasNextLine()){
                String temp=scan.nextLine()+"\n";
                scroll.append(temp);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    void selectSize(){
        int size = (int) JOptionPane.showInputDialog(
                    tabs,
                    "Select size",
                    "Select size",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    MainWindow.config.getSize());
        if (size == 0) return;
        MainWindow.config.setSize(size);
        updateFont(size);
    }
    private void updateFont(int size){
        Font font = new Font("",Font.PLAIN,size);
        Scroll.font = font;
        if (tabs.getTabCount() == 0)return;

        for(int i = 0 ; i < tabs.getComponentCount() - 1;i++){
            Scroll scroll = (Scroll) tabs.getComponent(i);
            scroll.setFonts(font);
        }


    }
}
