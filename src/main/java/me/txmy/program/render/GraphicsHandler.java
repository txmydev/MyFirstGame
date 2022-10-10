package me.txmy.program.render;

import me.txmy.program.background.Background;
import me.txmy.program.entity.Entity;
import me.txmy.program.entity.EntityManager;
import me.txmy.program.game.Game;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GraphicsHandler extends Canvas implements Runnable {

    private static final double TICK_RATE = 60.0;

    private boolean running;
    private final Game game = new Game();
    private final Background background;

    public GraphicsHandler() {
        background = new Background("background.jpg");
    }

    public void start() {
        running = true;

        new Thread(this).start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double delta = 0;
        double nsPerTick = 1000000000.0 / TICK_RATE;
        long timer = System.currentTimeMillis();
        int ticks = 0;
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;

            while (delta >= 1) {
                ticks++;
                tick();
                delta -= 1;
            }

            {
                frames++;
                render();
            }

            try {
                Thread.sleep(2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (System.currentTimeMillis() - timer > 1000) {
                System.out.println(ticks + " ticks, " + frames + " fps");
                timer += 1000;
                frames = 0;
                ticks = 0;
            }
        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        //g.fillRect(0, 0, Common.WIDTH * 2, Common.HEIGHT * 2);
        background.draw(g);

        EntityManager entityManager = game.getEntityManager();
        entityManager.getEntityList().forEach(entity -> {
            entity.draw(g);
        });

        g.dispose();
        bs.show();
    }

    public void tick() {
        EntityManager entityManager = game.getEntityManager();
        entityManager.getEntityList().forEach(Entity::update);
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
