package Scenes;

import Game.Game;
import helpz.LevelBuild;

import java.awt.*;

public class World extends GameScene implements SceneMethods {
    private int[][] lvl;

    public World(Game game){
        super(game);
        lvl = LevelBuild.getLevelData();
    }

    @Override
    public void render(Graphics g) {
        for (int y = 0; y < lvl.length; y++) {
            for (int x = 0; x < lvl[y].length; x++) {
                int id = lvl[y][x];
                g.drawImage(super.getGame().getSprites().get(lvl[y][x]).getSprite(),x*32,y*32,null);
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


//for (int i = 0; i < 480; i+=32) {
//        for (int j = 0; j < 320; j+=32) {
//        g.drawImage(super.getGame().getSprites().get("grass1").getSprite(), i, j,null);
//        }
//        }
//        for (int i = 64; i < 480-64; i+=32) {
//        for (int j = 0; j < 64; j+=32) {
//        g.drawImage(super.getGame().getSprites().get("wildGrass").getSprite(), i, j,null);
//        }
//        }
