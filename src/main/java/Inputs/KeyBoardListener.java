package Inputs;

import Game.Game;
import Game.GameStates;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Game.GameStates.*;

public class KeyBoardListener implements KeyListener {
    private Game game;

    public KeyBoardListener(Game game){
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A){
            GameStates.gameState = MENU;
        }
        else if (e.getKeyCode() == KeyEvent.VK_S){
            GameStates.gameState = BATTLE;
        }
        else if (e.getKeyCode() == KeyEvent.VK_D){
            GameStates.gameState = WORLD;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
