package me.txmy.program;

import me.txmy.program.render.GraphicsHandler;
import me.txmy.program.utils.Common;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(Common.WIDTH, Common.HEIGHT));
        frame.setResizable(false);
        frame.setTitle(Common.TITLE);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicsHandler graphicsHandler = new GraphicsHandler();
        frame.add(graphicsHandler);
        frame.pack();

        frame.setVisible(true);
        graphicsHandler.start();
    }

}
