package Objects;

import java.awt.image.BufferedImage;

public class Tile {
    private String name;
    private int width;
    private int height;
    private boolean canMove;
    private BufferedImage img;

    public Tile(String name, int width, int height, boolean canMove, BufferedImage sprite ) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.canMove = canMove;
        this.img = sprite;
    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isCanMove() {
        return canMove;
    }

    public BufferedImage getSprite(){
        return img;
    }
}
