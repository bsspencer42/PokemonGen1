package Scenes;

import Game.Game;
import UI.MyButton;

import java.awt.*;
import static Game.GameStates.*;

public class Menu extends GameScene {
    private MyButton bPlay, bEdit, bQuit;

    public Menu(Game game) {
        super(game);
        initButtons();
    }

    private void initButtons() {
        bPlay = new MyButton("Play", 175, 80, 100, 30);
        bEdit = new MyButton("World Editor", 175, 130, 100,30);
        bQuit = new MyButton("Quit", 175, 180, 100, 30);
    }


    @Override
    public void render(Graphics g) {
        drawButtons(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (bEdit.getBounds().contains(x,y)){
            SetGameState(WORLDEDITOR);
        }
        else if (bPlay.getBounds().contains(x,y)){
            SetGameState(PLAY);
        }
        else if (bQuit.getBounds().contains(x,y)){
            System.exit(0);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        resetButtons();
        if (bEdit.getBounds().contains(x,y)){
            bEdit.setMouseOver(true);
        }
        else if (bPlay.getBounds().contains(x,y)){
            bPlay.setMouseOver(true);
        }
        else if (bQuit.getBounds().contains(x,y)){
            bQuit.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (bEdit.getBounds().contains(x,y)){
            bEdit.setMousePressed(true);
        }
        else if (bPlay.getBounds().contains(x,y)){
            bPlay.setMousePressed(true);
        }
        else if (bQuit.getBounds().contains(x,y)){
            bQuit.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        bPlay.resetBooleans();
        bEdit.resetBooleans();
        bQuit.resetBooleans();
    }

    private void drawButtons(Graphics g) {
        bPlay.draw(g);
        bEdit.draw(g);
        bQuit.draw(g);
    }

}
