package Scenes;

import Game.Game;
import Objects.Level;
import helpz.ImageModify;
import helpz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Battle extends GameScene {
    private Level lvl;

    public Battle(Game game) {
        super(game);
        this.lvl = LoadSave.loadDefaultLevel();
    }

    @Override
    public void render(Graphics g) {
        BufferedImage currentImg;
        for (int y = 0; y < lvl.getBase().length; y++) {
            for (int x = 0; x < lvl.getBase()[y].length; x++) {
                // Overlay
                if (lvl.getBase2()[y][x] != -1) {
                    BufferedImage[] imgs = {getGame().getSprites().get(lvl.getBase()[y][x]).getSprite(),getGame().getSprites().get(lvl.getBase2()[y][x]).getSprite()};
                    currentImg = ImageModify.buildImg(imgs);
                }
                else{
                    currentImg = getGame().getSprites().get(lvl.getBase()[y][x]).getSprite();
                }
                g.drawImage(currentImg, x * 32, y * 32, null);
            }
        }
    }

    @Override
    public void mouseClicked(int x, int y) {

    }

    @Override
    public void mouseMoved(int x, int y) {

    }

    @Override
    public void mousePressed(int x, int y) {

    }

    @Override
    public void mouseReleased(int x, int y) {

    }


}
