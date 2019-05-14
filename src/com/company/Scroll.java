package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

class Scroll extends JScrollPane
{
    private String name;
    private JTextArea text;
    static Font font;

    Scroll(JTextArea text,String name)
    {
        super(text);

        this.text = text;
        this.name = name;
        text.addKeyListener(MainWindow.Listeners.getKeyadapter());
        this.text.setFont(Scroll.font);
    }

    void setEditable(boolean status){
        this.text.setEditable(status);
    }
    void setFonts(Font font){
        this.text.setFont(font);
    }
    void append(String text){
        this.text.append(text);
    }
    String getText() {
        return text.getText();
    }
}
