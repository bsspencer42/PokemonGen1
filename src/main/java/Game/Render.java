package Game;

import java.awt.*;

public class Render {
    // Instance Variables
    private Game game;

    public Render(Game game){
        this.game = game;
    }

    public void render(Graphics g){
        switch (GameStates.gameState){
            case WORLD:
                game.getWorld().render(g);
                break;
            case BATTLE:
                game.getBattle().render(g);
                break;
            case MENU:
                game.getMenu().render(g);
                break;
        }
    }

}
