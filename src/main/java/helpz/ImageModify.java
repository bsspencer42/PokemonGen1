package helpz;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageModify {

    public static BufferedImage buildImg(BufferedImage[] imgs){
        int w = imgs[0].getWidth();
        int h = imgs[0].getHeight();

        BufferedImage newImg = new BufferedImage(w,h,imgs[0].getType());
        Graphics2D g2d = newImg.createGraphics();

        for (BufferedImage img : imgs){
            g2d.drawImage(img,0,0,null);
        }
        g2d.dispose();
        return newImg;
    }
}
