package me.txmy.program.listener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.txmy.program.utils.Callback;

import java.awt.event.MouseEvent;

@Getter @Setter (value = AccessLevel.PRIVATE)
public class PMouseListener extends DefaultMouseListener {

    private Callback<MouseEvent> clickCallback;
    private Callback<MouseEvent> pressCallback;
    private Callback<MouseEvent> enteredCallback;
    private Callback<MouseEvent> exitedCallback;
    private Callback<MouseEvent> releasedCallback;

    public PMouseListener() {
    }

    public PMouseListener(Callback<MouseEvent> clickCallback, Callback<MouseEvent> pressCallback, Callback<MouseEvent> enteredCallback, Callback<MouseEvent> exitedCallback, Callback<MouseEvent> releasedCallback) {
        this.clickCallback = clickCallback;
        this.pressCallback = pressCallback;
        this.enteredCallback = enteredCallback;
        this.exitedCallback = exitedCallback;
        this.releasedCallback = releasedCallback;
    }

    public PMouseListener setClickCallback(Callback<MouseEvent> callback) {
        setClickCallback(callback);
        return this;
    }

    public PMouseListener setPressCallback(Callback<MouseEvent> callback) {
        setPressCallback(callback);
        return this;
    }

    public PMouseListener setEnteredCallback(Callback<MouseEvent> callback) {
        setEnteredCallback(callback);
        return this;
    }

    public PMouseListener setExitedCallback(Callback<MouseEvent> callback) {
        setExitedCallback(callback);
        return this;
    }

    public PMouseListener setReleasedCallback(Callback<MouseEvent> callback) {
        setReleasedCallback(callback);
        return this;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(releasedCallback != null) releasedCallback.callback(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(pressCallback != null) pressCallback.callback(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(clickCallback != null) clickCallback.callback(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(enteredCallback != null) enteredCallback.callback(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        exitedCallback.callback(e);
    }
}
