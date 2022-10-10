package me.txmy.program.listener;

import me.txmy.program.utils.Callback;

import java.awt.event.KeyEvent;

public class KeyPressListener extends DefaultKeyListener {

    private final int keyCode;
    private final Callback<KeyEvent> callback;

    public KeyPressListener(int keyCode, Callback<KeyEvent> callback) {
        this.keyCode = keyCode;
        this.callback = callback;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(keyCode == e.getKeyCode()) {
            callback.callback(e);
        }
    }
}
