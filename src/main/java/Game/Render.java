package Game;

import Scenes.GameScene;
import Scenes.SceneMethods;

import java.awt.*;

public class Render {
    // Instance Variables
    private Game game;
    private GameStates previousState;

    public Render(Game game){
        this.game = game;
        this.previousState = GameStates.gameState;
    }

    public void render(Graphics g){
        GameScene currentScene = null;
        switch (GameStates.gameState){
            case WORLD:
                currentScene = game.getWorld();
                break;
            case BATTLE:
                currentScene = game.getBattle();
                break;
            case MENU:
                currentScene = game.getMenu();
                break;
            case WORLDEDITOR:
                currentScene = game.getWorldEditor();
                break;
        }
        // Resize screen if state change
        if (previousState != GameStates.gameState){
            game.getGameScreen().setPanelSize(currentScene.getWidth(),currentScene.getHeight());
        }
        // Render screen
        currentScene.render(g);
        previousState = GameStates.gameState;
    }

}
