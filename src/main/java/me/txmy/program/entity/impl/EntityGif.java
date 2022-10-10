package me.txmy.program.entity.impl;

import me.txmy.program.entity.Entity;
import me.txmy.program.utils.Vector;

import java.awt.*;

public class EntityGif extends Entity {

    private Image image;

    public EntityGif(Vector position, Image image) {
        super(position, new Vector(0,0,0), Color.WHITE);
        this.image = image;
    }

    @Override
    public void draw(Graphics g) {

    }
}
