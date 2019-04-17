package com.company;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class MyListener {
    private KeyListener keyadapter;
    private Actions actions;

    MyListener(JTabbedPane tabs){

        actions = new Actions(tabs);
        keyadapter = new KeyListener() {
            public void keyTyped(KeyEvent keyEvent) {

            }
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_N && keyEvent.isControlDown()) {
                    actions.new_file();
                }
                if (keyEvent.getKeyCode() == KeyEvent.VK_O && keyEvent.isControlDown()) {
                    actions.open_file();
                }
                if (keyEvent.getKeyCode() == KeyEvent.VK_S && keyEvent.isControlDown()) {

                    actions.save_file();
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
