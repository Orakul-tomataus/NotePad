package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

class Config {
    private Properties properties;
    private File configFile;

    Config(String fileName){
        configFile = new File(fileName);
        properties = new Properties();
        readConfig();
        Scroll.font = new Font("",Font.PLAIN,getSize());

    }
    private void writeConfig(){
        try {
            FileWriter writer = new FileWriter(configFile);
            properties.store(writer, "settings");
            writer.close();
        }catch (IOException ex) {
            System.out.print("Error writer");
        }
    }
    private void readConfig(){
        try {
            FileReader reader = new FileReader(configFile);
            properties.load(reader);
            reader.close();
        }catch (IOException ex) {
            System.out.print("Error read");
        }
    }
    int getSize(){
        String size = properties.getProperty("size");
        return Integer.parseInt(size);
    }
    void setSize(int value){
        String size = String.valueOf(value);
        properties.setProperty("size",size);
        writeConfig();
    }
    String[] getKeysNewFile(){
        return properties.getProperty("new_file").split("-");
    }
    String[] getKeysOpenFile(){
        return properties.getProperty("open_file").split("-");
    }
    String[] getKeysSaveFile(){
        return properties.getProperty("save_file").split("-");
    }
    String[] getKeysQuit(){
        return properties.getProperty("quit").split("-");
    }
}
