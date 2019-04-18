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
    private JTabbedPane tabs;
    private JFileChooser f = new JFileChooser();

    Actions(JTabbedPane tabs){
        this.tabs = tabs;
    }

    void new_file()
    {
        if (tabs.countComponents() != 0){
            Scroll select = (Scroll)tabs.getSelectedComponent();
            select.setEditable(false);
            JTextArea text = new JTextArea();
            Scroll scroll = new Scroll(text,NAME,tabs);
            tabs.addTab(NAME,scroll);
            select.setEditable(true);
        } else {
            JTextArea text = new JTextArea();
            Scroll scroll = new Scroll(text,NAME,tabs);
            tabs.addTab(NAME,scroll);
        }


    }
    void save_file()
    {
        if (tabs.countComponents() != 0)
        {
            Scroll selectedComponent = (Scroll)tabs.getSelectedComponent();
            selectedComponent.setEditable(false);
            String output = selectedComponent.getText();
            f.showSaveDialog(null);
            File file = f.getSelectedFile();
            if (file != null){
                try(FileWriter writer = new FileWriter(file,false)){
                    writer.write(output);
                }catch (IOException eq) {
                    eq.printStackTrace();
                }
            }
            selectedComponent.setEditable(true);
        }
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
                Scroll scroll = new Scroll(text,file.getName(),tabs);
                tabs.addTab(file.getName(),scroll);
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    void selectSize(){
        Object[] possibilities = {10,15, 20,30,40,50,100};
        int size = (int)JOptionPane.showInputDialog(
                tabs,
                "Select size",
                "Select size",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                10);
        Font font = new Font("",Font.PLAIN,size);
        for(int i = 0 ; i < tabs.getComponentCount();i++){
            Scroll scroll = (Scroll) tabs.getComponent(i);
            scroll.setFonts(font);
        }
        Scroll.font = font;
    }

}
