package com.company;

import javax.swing.*;
import java.awt.*;

class Scroll extends JScrollPane
{
    static MyListener myListener;

    boolean SaveStatus = false;
    private String name;
    private JTextArea text;
    static Font font;
    Scroll(JTextArea text,String name){
        super(text);
        this.text = text;
        this.name = name;
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
