package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class MyListener {
    private String[] keyNew = MainWindow.config.getKeysNewFile();
    private String[] keyOpen= MainWindow.config.getKeysOpenFile();
    private String[] keySave= MainWindow.config.getKeysSaveFile();
    private KeyListener keyadapter;

    MyListener(Actions actions){
        keyadapter = new KeyListener() {
            public void keyTyped(KeyEvent keyEvent) {

            }
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.isControlDown()){

                if (keyEvent.getKeyCode() == (int) keyNew[1].charAt(0))  actions.new_file();

                if (keyEvent.getKeyCode() == (int) keyOpen[1].charAt(0)) actions.open_file();

                if (keyEvent.getKeyCode() == (int) keySave[1].charAt(0)) actions.save_file();
                }
            }

            public void keyReleased(KeyEvent keyEvent) {

            }
        };
    }

    KeyListener getKeyadapter() {
        return keyadapter;
    }
}
