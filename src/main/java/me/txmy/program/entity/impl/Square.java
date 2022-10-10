package me.txmy.program.entity.impl;

import lombok.Getter;
import lombok.Setter;
import me.txmy.program.entity.Entity;
import me.txmy.program.utils.Common;
import me.txmy.program.utils.Vector;

import java.awt.*;

@Getter
public class Square extends Entity {

    private int size;

    @Setter
    private boolean fill = false;
    private Vector velocity;

    public Square(Vector position, Vector velocity, Color color, int size) {
        super(position, new Vector(0,0,0), color);
        this.size = size;
        this.velocity = velocity;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);

        if(fill) g.drawRect(this.position.getBlockX(), this.position.getBlockY(), this.size, this.size);
        else g.fillRect(this.position.getBlockX(), this.position.getBlockY(), this.size, this.size);
    }

    @Override
    public void update() {
        this.position.add(this.velocity);

        int x = this.position.getBlockX();
        int y = this.position.getBlockY();

        if(y <= 0 + this.size || y >= Common.HEIGHT - this.size) this.velocity.invertY();
        if(x >= Common.WIDTH - this.size || x <= 0 + this.size) this.velocity.invertX();
    }
}
