package Objects;

import java.awt.image.BufferedImage;

public class Tile {
    private String name;
    private int id;
    private int width;
    private int height;
    private String canMove;
    private int layer;
    private BufferedImage sprite;

    public Tile(String name, int id, int width, int height, String canMove, BufferedImage sprite, int layer) {
        this.name = name;
        this.id = id;
        this.width = width;
        this.height = height;
        this.canMove = canMove;
        this.sprite = sprite;
        this.layer = layer;
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

    public String getCanMove() {
        return canMove;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public int getId() {
        return id;
    }

    public int getLayer() {
        return layer;
    }
}
