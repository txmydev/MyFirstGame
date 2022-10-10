package me.txmy.program.background;

import lombok.Getter;
import lombok.SneakyThrows;
import me.txmy.program.utils.Common;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

@Getter
public class Background {

    private final Color color = Color.GRAY;
    private Image image;

    @SneakyThrows
    public Background(String fileName) {
        image = ImageIO.read(new File(Common.LOCAL_DIR + "/resources/" + fileName));
    }

    public void draw(Graphics g) {
        g.drawImage(image, 0, 0, Common.WIDTH, Common.HEIGHT, null, null);
    }

}
