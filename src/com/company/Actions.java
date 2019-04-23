package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Actions
{
    private final String NAME = "New file";
    private final Object[] possibilities = {10,15,20,30,40,50,100};
    private JFileChooser f;

    private JTabbedPane tabs;

    Actions(JTabbedPane tabs){
        f = new JFileChooser();
        this.tabs = tabs;
    }

    void new_file()
    {
        JTextArea text = new JTextArea();
        Scroll scroll = new Scroll(text,NAME);
        tabs.addTab(NAME,scroll);
    }
    void save_file()
    {
        Scroll selectedComponent = (Scroll)tabs.getSelectedComponent();
        if (selectedComponent == null) return;

        selectedComponent.setEditable(false);
        String output = selectedComponent.getText();
        f.showSaveDialog(null);
        File file = f.getSelectedFile();
        if (file == null) return;

        try(FileWriter writer = new FileWriter(file,false)){
            writer.write(output);
        }catch (IOException eq) {
            eq.printStackTrace();
        }

        selectedComponent.setEditable(true);

    }
    void open_file()
    {
        f.showOpenDialog(null);
        File file = f.getSelectedFile();
        if (file != null){
            try(FileReader reader = new FileReader(file))
            {
                char[] buf = new char[256];
                StringBuilder input = new StringBuilder();
                JTextArea text;
                while (reader.read(buf) > 0)
                    input.append(String.copyValueOf(buf));
                text = new JTextArea(input.toString());
                Scroll scroll = new Scroll(text,file.getName());
                tabs.addTab(file.getName(),scroll);
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }

    void selectSize(){
        int size = (int)JOptionPane.showInputDialog(
                tabs,
                "Select size",
                "Select size",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                MainWindow.config.getSize());
        MainWindow.config.setSize(size);
        setFont(size);
    }
    private void setFont(int size){
        Font font = new Font("",Font.PLAIN,size);
        for(int i = 0 ; i < tabs.getComponentCount();i++){
            Scroll scroll = (Scroll) tabs.getComponent(i);
            scroll.setFonts(font);
        }
        Scroll.font = font;
    }
}
