package Objects;

import java.awt.image.BufferedImage;

public class Tile {
    private String name;
    private int id;
    private int width;
    private int height;
    private boolean canMove;
    private BufferedImage sprite;

    public Tile(String name, int id, int width, int height, boolean canMove, BufferedImage sprite ) {
        this.name = name;
        this.id = id;
        this.width = width;
        this.height = height;
        this.canMove = canMove;
        this.sprite = sprite;
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

    public BufferedImage getSprite() {
        return sprite;
    }

    public int getId() {
        return id;
    }
}
