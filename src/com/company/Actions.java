package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Actions
{
    private final Object[] possibilities = {10,15,20,30,40,50,100};
    private JFileChooser f;
    private JTabbedPane tabs;

    Actions(JTabbedPane tabs){
        f = new JFileChooser();
        this.tabs = tabs;
    }

    void new_file()
    {
        createTabs("","New file");
    }

    private void createTabs(String context,String name)
    {
        JTextArea text = new JTextArea(context);
        Scroll scroll = new Scroll(text,name);
        tabs.addTab(name,scroll);
        int id = tabs.getTabCount();
        id -= 1;
        JPanel pnlTab = new JPanel(new BorderLayout());
        pnlTab.setOpaque(false);
        JLabel lblTitle = new JLabel(name);
        JButton btnClose = new JButton("x");
        pnlTab.add(lblTitle,BorderLayout.WEST);
        pnlTab.add(btnClose,BorderLayout.EAST);
        tabs.setTabComponentAt(id, pnlTab);
        btnClose.addActionListener(actionEvent -> {
            Component selected = tabs.getSelectedComponent();
            if (selected != null) {
                tabs.remove(selected);
            }
        });

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
        if (file == null) return;
        try(FileReader reader = new FileReader(file))
        {
            char[] buf = new char[256];
            StringBuilder input = new StringBuilder();
            while (reader.read(buf) > 0)
                input.append(String.copyValueOf(buf));
            createTabs(input.toString(),file.getName());
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
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

    void quit(){

        System.exit(0);
    }
}
