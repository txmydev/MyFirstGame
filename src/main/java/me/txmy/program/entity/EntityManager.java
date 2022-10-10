package me.txmy.program.entity;

import lombok.Getter;
import me.txmy.program.entity.impl.Square;
import me.txmy.program.utils.Common;
import me.txmy.program.utils.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {

    @Getter
    private final List<Entity> entityList = new ArrayList<>();

    public void init() {
        createSquare(Common.MIDDLE_WIDTH, Common.MIDDLE_HEIGHT, 1, 1, Color.RED, 50);
    }

    public void createSquare(int x, int y, int velX, int velY, Color color, int size) {
        Vector position = new Vector(x, y, 0);
        Vector direction = new Vector(velX, velY,0);

        entityList.add(new Square(position, direction, color, size));
    }
}
