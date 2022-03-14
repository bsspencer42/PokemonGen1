package Scenes;

import Game.Game;

import java.awt.*;

public class GameScene implements SceneMethods {
    private Game game;
    private int width;
    private int height;

    // Default screen size
    public GameScene(Game game){
        this(game, 480, 320);
    }
    public GameScene(Game game, int width, int height){
        this.game = game;
        this. width = width;
        this.height = height;
    }

    public Game getGame(){
        return game;
    }

    @Override
    public void render(Graphics g) {

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
