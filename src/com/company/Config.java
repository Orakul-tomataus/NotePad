package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

class Config {
    private static File configFile;
    static int FontSize;

    Config(String fileName){
        configFile = new File(fileName);
        readConfig();
    }
    static void writeConfig(){
        try {
            FileWriter writer = new FileWriter(configFile);
            Properties properties = new Properties();

            properties.setProperty("size",String.valueOf(FontSize));

            properties.store(writer, "settings");
            writer.close();
        }catch (IOException ex) {
            // I/O error
        }
    }
    private static void readConfig(){
        try {
            FileReader reader = new FileReader(configFile);
            Properties properties = new Properties();
            properties.load(reader);

            FontSize = Integer.parseInt(properties.getProperty("size"));

            reader.close();
        }catch (IOException ex) {
            // I/O error
        }
    }
}
