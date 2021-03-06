package Inputs;

import Game.Game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import Game.GameStates;

public class MyMouseListener implements MouseListener, MouseMotionListener {
    private Game game;

    public MyMouseListener(Game game){
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){
            System.out.println(+e.getX() + ", "+e.getY());
            switch (GameStates.gameState){
                case MENU:
                    game.getMenu().mouseClicked(e.getX(),e.getY());
                    break;
                case PLAY:
                    break;
                case BATTLE:
                    break;
                case WORLDEDITOR:
                    game.getWorldEditor().mouseClicked(e.getX(),e.getY());
                    break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (GameStates.gameState){
            case MENU:
                game.getMenu().mousePressed(e.getX(),e.getY());
                break;
            case PLAY:
                break;
            case BATTLE:
                break;
            case WORLDEDITOR:
                game.getWorldEditor().mousePressed(e.getX(),e.getY());
                break;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (GameStates.gameState){
            case MENU:
                game.getMenu().mouseReleased(e.getX(),e.getY());
                break;
            case PLAY:
                break;
            case BATTLE:
                break;
            case WORLDEDITOR:
                game.getWorldEditor().mouseReleased(e.getX(),e.getY());
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (GameStates.gameState){
            case MENU:
                break;
            case PLAY:
                break;
            case BATTLE:
                break;
            case WORLDEDITOR:
                game.getWorldEditor().mouseDragged(e.getX(),e.getY());
                break;
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (GameStates.gameState){
            case MENU:
                game.getMenu().mouseMoved(e.getX(),e.getY());
                break;
            case PLAY:
                break;
            case BATTLE:
                break;
            case WORLDEDITOR:
                game.getWorldEditor().mouseMoved(e.getX(),e.getY());
                break;
        }

    }
}
