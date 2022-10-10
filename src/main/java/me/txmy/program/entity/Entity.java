package me.txmy.program.entity;

import lombok.Getter;
import lombok.Setter;
import me.txmy.program.listener.DefaultKeyListener;
import me.txmy.program.listener.DefaultMouseListener;
import me.txmy.program.listener.PMouseListener;
import me.txmy.program.utils.Vector;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

@Setter @Getter
public abstract class Entity {

    private static final KeyListener DEFAULT_KEY_LISTENER = new DefaultKeyListener();
    private static final MouseListener DEFAULT_MOUSE_LISTENER = new PMouseListener();
    private static int ID_COUNTER = 0;

    protected int id;
    protected Vector position, direction;
    protected Color color;
    protected KeyListener keyListener;
    protected MouseListener mouseListener;

    public Entity(Vector position, Vector direction, Color color, KeyListener keyListener, MouseListener mouseListener) {
        this.id = getAndIncrementIdCounter();
        this.position = position;
        this.direction = direction;
        this.color = color;
        this.keyListener = keyListener;
        this.mouseListener = mouseListener;
    }

    public Entity(Vector position, Vector direction, Color color) {
        this(position, direction, color, DEFAULT_KEY_LISTENER, DEFAULT_MOUSE_LISTENER);
    }
    

    public abstract void draw(Graphics g);
    public void update() { }

    public int getId() {
        return this.id;
    }

    private static int getAndIncrementIdCounter(){
        int val = ID_COUNTER;
        ID_COUNTER ++;
        return val;
    }

}
