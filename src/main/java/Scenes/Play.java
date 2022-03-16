package Scenes;

import Game.Game;
import helpz.LoadSave;

import java.awt.*;

public class Play extends GameScene {
    private int[][] lvl;

    public Play(Game game) {
        super(game);
        this.lvl = LoadSave.loadDefaultLevel();
    }

    @Override
    public void render(Graphics g) {
        // Render lvl from 2d array
        for (int y = 0; y < lvl.length; y++) {
            for (int x = 0; x < lvl[y].length; x++) {
                int id = lvl[y][x];
                g.drawImage(super.getGame().getSprites().get(id).getSprite(), x * 32, y * 32, null);
            }
        }
    }

    public void setLvl(int[][] lvl){
        this.lvl = lvl;
    }

}
