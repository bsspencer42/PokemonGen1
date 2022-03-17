package UI;

import Game.Game;
import Objects.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static Game.GameStates.*;

public class BottomBar {

    private int x, y, width, height;
    private MyButton menu, save, previous, next,selectedTileName;
    private Game game;
    private ArrayList<MyButton> tileButtons = new ArrayList<>();
    private Tile selectedTile;
    private int beginDisplayTile = 0;
    private int numDisplayTiles = 80;

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
        save = new MyButton("Save", 15, 370,80,30);
        previous = new MyButton("Previous",15,410,80,30);
        next = new MyButton("Next",15,450,80,30);
        drawTiles();
    }

    private void drawTiles(){
        int w = 32;
        int h = 32;
        int xStart=110;
        int yStart=330;
        int xOffSet =  (int) (w*1.1f);
        int yOffSet = (int) (h*1.1f);
        int currentYoffSet;
        tileButtons = new ArrayList<>();
        int currentId;

        for (int i = 0; i < numDisplayTiles;i++) {
            currentYoffSet = (xOffSet*i / 350) * yOffSet;
            currentId = (beginDisplayTile+i) % game.getSprites().size();
            tileButtons.add(new MyButton(game.getSprites().get(currentId).getName(),
                    xStart+(xOffSet*i % 350), yStart+currentYoffSet,w,h,game.getSprites().get(currentId).getId()));
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
        save.draw(g);
        previous.draw(g);
        next.draw(g);
        // Draw tile buttons
        drawTileButtons(g);
        // Draw selected tile
        drawSelectedTile(g);
    }

    private void drawSelectedTile(Graphics g) {
        if (selectedTile != null){
            g.drawImage(selectedTile.getSprite(),40, 490 , 32, 32, null);
            g.setColor(Color.BLACK);
            selectedTileName = new MyButton(selectedTile.getName(),15,540,80,30);
            selectedTileName.draw(g);
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
        else if (save.getBounds().contains(x,y)){
            saveLevel();
        }
        else if (previous.getBounds().contains(x,y)){
            // Wrap around if negative
            if (beginDisplayTile < numDisplayTiles){
                beginDisplayTile = game.getSprites().size()+(beginDisplayTile - numDisplayTiles);
            }else {
                beginDisplayTile-=numDisplayTiles;
            }
            System.out.println(beginDisplayTile);
            drawTiles();
        }
        else if (next.getBounds().contains(x,y)){
            beginDisplayTile = (beginDisplayTile+numDisplayTiles) % game.getSprites().size();
            System.out.println(beginDisplayTile);
            drawTiles();
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

    private void saveLevel() {
        game.getWorldEditor().saveLevel();
    }

    public void mouseMoved(int x, int y) {
        // Reset state
        resetButtons();
        // MouseOver for Menu button
        if (menu.getBounds().contains(x,y)){
            menu.setMouseOver(true);
        }
        else if (save.getBounds().contains(x,y)){
            save.setMouseOver(true);
        }
        else if (previous.getBounds().contains(x,y)){
            previous.setMouseOver(true);
        }
        else if (next.getBounds().contains(x,y)){
            next.setMouseOver(true);
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
        else if (save.getBounds().contains(x,y)){
            save.setMousePressed(true);
        }
        else if (previous.getBounds().contains(x,y)){
            previous.setMousePressed(true);
        }
        else if (next.getBounds().contains(x,y)){
            next.setMousePressed(true);
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
        save.resetBooleans();
        previous.resetBooleans();
        next.resetBooleans();
        for (MyButton b : tileButtons){
            b.setMouseOver(false);
            b.resetBooleans();
        }
    }

}
