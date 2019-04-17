package com.company;

import java.awt.*;

class Fonts extends Font
{
    Fonts(){
        super("name", Font.PLAIN,10);
    }
    void setSize(int size){
        this.size = size;
    }
}
