package me.txmy.program.game;

import lombok.Getter;
import me.txmy.program.background.Background;
import me.txmy.program.entity.EntityManager;

import java.awt.*;

@Getter
public class Game {

    private final EntityManager entityManager;
    private final Color backgroundColor = Color.BLACK;

    public Game() {
        (entityManager = new EntityManager()).init();
    }
}
