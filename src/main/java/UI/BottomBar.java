package UI;

import Game.Game;
import Objects.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static Game.GameStates.*;

public class BottomBar {

    private int x, y, width, height;
    private MyButton menu;
    private Game game;
    private ArrayList<MyButton> tileButtons = new ArrayList<>();
    private Tile selectedTile;

    public BottomBar(int x, int y, int width, int height, Game game) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.game = game;
        initButtons();
    }

    private void initButtons() {
        menu = new MyButton("Menu", 15, 330, 80,30);

        int w = 32;
        int h = 32;
        int xStart=110;
        int yStart=330;
        int xOffSet =  (int) (w*1.1f);
        int i = 0;

        for (Tile sprite : game.getSprites()) {
            tileButtons.add(new MyButton(sprite.getName(), xStart+xOffSet*i, yStart,w,h,sprite.getId()));
            i++;
        }

    }

    public void draw(Graphics g){
        // Background
        g.setColor(new Color(220,123,14));
        g.fillRect(x,y,width,height);
        // Buttons
        drawButtons(g);
    }

    private void drawButtons(Graphics g) {
        // Draw menu
        menu.draw(g);
        // Draw tile buttons
        drawTileButtons(g);
        // Draw selected tile
        drawSelectedTile(g);
    }

    private void drawSelectedTile(Graphics g) {
        if (selectedTile != null){
            g.drawImage(selectedTile.getSprite(),440, 330 , 32, 32, null);
            g.setColor(Color.BLACK);
            g.drawRect(440,330,32,32);
        }
    }

    private void drawTileButtons(Graphics g) {
        // Draw tile image on each button
        for (MyButton b : tileButtons) {
            // Sprite
            BufferedImage sprite = game.getSprites().get(b.getId()).getSprite();
            g.drawImage(sprite,b.getX(),b.getY(),b.getWidth(),b.getHeight(),null);

            // MouseOver
            if(b.isMouseOver()){
                g.setColor(Color.WHITE);
            }
            else {
                g.setColor(Color.BLACK);
            }
            // Border
            g.drawRect(b.getX(),b.getY(),b.getWidth(),b.getHeight());
            // MousePressed
            if (b.isMousePressed()){
                g.drawRect(b.getX()+1,b.getY()+1,b.getWidth()-2,b.getHeight()-2);
                g.drawRect(b.getX()+2,b.getY()+2,b.getWidth()-4,b.getHeight()-4);
            }
        }

    }

    // Mouse Interaction
    public void mouseClicked(int x, int y) {
        // Return to menu
        if (menu.getBounds().contains(x,y)){
            SetGameState(MENU);
        }
        // Select tile
        else {
            for (MyButton b : tileButtons){
                if (b.getBounds().contains(x,y)){
                    selectedTile = game.getSprites().get(b.getId());
                    game.getWorldEditor().setSelectedTile(selectedTile);
                }
            }
        }
    }

    public void mouseMoved(int x, int y) {
        // Reset state
        resetButtons();
        // MouseOver for Menu button
        if (menu.getBounds().contains(x,y)){
            menu.setMouseOver(true);
        }
        // MouseOver for tilebuttons
        else {
            for(MyButton b : tileButtons){
                if (b.getBounds().contains(x,y)){
                    b.setMouseOver(true);
                    return;
                }
            }
        }
    }

    public void mousePressed(int x, int y) {
        // Mouse pressed for menu button
        if (menu.getBounds().contains(x,y)){
            menu.setMousePressed(true);
        }
        else {
            for(MyButton b : tileButtons){
                if (b.getBounds().contains(x,y)){
                    b.setMousePressed(true);
                    return;
                }
            }
        }
    }

    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        menu.resetBooleans();
        for (MyButton b : tileButtons){
            b.setMouseOver(false);
            b.resetBooleans();
        }
    }

}
