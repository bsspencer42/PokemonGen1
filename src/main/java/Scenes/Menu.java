package Scenes;

import Game.Game;
import UI.MyButton;
import helpz.LevelBuild;

import java.awt.*;
import static Game.GameStates.*;

public class Menu extends GameScene implements SceneMethods {
    private int[][] lvl;
    private MyButton bWorld, bQuit;

    public Menu(Game game) {
        super(game);
        lvl = LevelBuild.getLevelData();
        initButtons();
    }

    private void initButtons() {
        bWorld = new MyButton("Play Pokemon", 175, 100, 100,30);
        bQuit = new MyButton("Quit", 175, 150, 100, 30);
    }


    @Override
    public void render(Graphics g) {
        drawButtons(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (bWorld.getBounds().contains(x,y)){
            SetGameState(WORLD);
        }
        if (bQuit.getBounds().contains(x,y)){
            System.exit(0);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        resetButtons();
        if (bWorld.getBounds().contains(x,y)){
            bWorld.setMouseOver(true);
        }
        if (bQuit.getBounds().contains(x,y)){
            bQuit.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (bWorld.getBounds().contains(x,y)){
            bWorld.setMousePressed(true);
        }
        if (bQuit.getBounds().contains(x,y)){
            bQuit.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        bWorld.resetBooleans();
        bQuit.resetBooleans();
    }

    private void drawButtons(Graphics g) {
        bWorld.draw(g);
        bQuit.draw(g);
    }

}
