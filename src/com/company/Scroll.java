package com.company;

import javax.swing.*;
import java.awt.*;

class Scroll extends JScrollPane
{
    private String name;
    private JTextArea text;
    static Font font;
    Scroll(JTextArea text,String name,JTabbedPane tabs){
        super(text);
        this.text = text;
        this.name = name;
        MyListener myListener = new MyListener(tabs);
        text.addKeyListener(myListener.getKeyadapter());
        this.text.setFont(Scroll.font);
    }

    void setEditable(boolean status){
        this.text.setEditable(status);
    }
    void setFonts(Font font){
        this.text.setFont(font);
    }
    String getText() {
        return text.getText();
    }



}
