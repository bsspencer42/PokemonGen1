package Scenes;

import Game.Game;
import UI.BottomBar;
import helpz.LevelBuild;

import java.awt.*;

public class WorldEditor extends GameScene {
    private int[][] lvl;
    private BottomBar bottomBar;

    public WorldEditor(Game game) {
        super(game,480, 420);
        lvl = LevelBuild.getLevelData();
        bottomBar = new BottomBar(0,320,480,100);
    }

    @Override
    public void render(Graphics g) {
        for (int y = 0; y < lvl.length; y++) {
            for (int x = 0; x < lvl[y].length; x++) {
                int id = lvl[y][x];
                g.drawImage(super.getGame().getSprites().get(lvl[y][x]).getSprite(), x * 32, y * 32, null);
            }
        }
        bottomBar.draw(g);
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