package com.company;

import javax.swing.*;
import java.awt.*;

class Scroll extends JScrollPane
{
    private String name;
    private JTextArea text;
    private Fonts fonts = new Fonts();
    Scroll(JTextArea text,String name,JTabbedPane tabs){
        super(text);
        this.text = text;
        this.name = name;
        MyListener myListener = new MyListener(tabs);
        text.addKeyListener(myListener.getKeyadapter());

        this.text.setFont(fonts);
        this.fonts.setSize(100);
    }

    void setEditable(boolean status){
        this.text.setEditable(status);
    }

    String getText() {
        return text.getText();
    }

}
