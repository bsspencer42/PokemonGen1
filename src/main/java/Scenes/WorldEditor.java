package Scenes;

import Game.Game;
import Objects.Level;
import Objects.Tile;
import UI.BottomBar;
import helpz.ImageModify;
import helpz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WorldEditor extends GameScene {
    private Level lvl;
    private BottomBar bottomBar;
    private Tile selectedTile;
    private int mouseX, mouseY;
    private int lastTileX, lastTileY, lastTileId;
    private boolean drawSelect;

    public WorldEditor(Game game) {
        super(game,480, 620);
        // Load Edit bar
        bottomBar = new BottomBar(0,320,480,300,getGame());
        // Load Default level
        this.lvl = LoadSave.loadDefaultLevel();
    }

    @Override
    public void render(Graphics g) {
        BufferedImage currentImg;
        for (int y = 0; y < lvl.getBase().length; y++) {
            for (int x = 0; x < lvl.getBase()[y].length; x++) {
                // Overlay
                if (lvl.getBase2()[y][x] != -1) {
                    BufferedImage[] imgs = {getGame().getSprites().get(lvl.getBase()[y][x]).getSprite(),getGame().getSprites().get(lvl.getBase2()[y][x]).getSprite()};
                    currentImg = ImageModify.buildImg(imgs);
                }
                else{
                    currentImg = getGame().getSprites().get(lvl.getBase()[y][x]).getSprite();
                }
                g.drawImage(currentImg, x * 32, y * 32, null);
            }
        }
        bottomBar.draw(g);
        drawSelectedTile(g);
    }

    private void drawSelectedTile(Graphics g){
        if (selectedTile != null && drawSelect){
            g.drawImage(selectedTile.getSprite(),mouseX,mouseY,32,32,null);
        }
    }

    public void setSelectedTile(Tile tile){
        this.selectedTile = tile;
        drawSelect = true;
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (y >= 320){
            bottomBar.mouseClicked(x,y);
        } else {
            changeTile(mouseX,mouseY);
        }
    }

    private void changeTile(int x, int y) {
        if (selectedTile != null){
            int tileX = x / 32;
            int tileY = y / 32;

            // Prevent calling when still hovering on same tile
            if (lastTileX == tileX && lastTileY == tileY && lastTileId == selectedTile.getId()){
                return;
            }
            lastTileX = tileX;
            lastTileY = tileY;
            lastTileId = selectedTile.getId();

            // Change tile in lvl array
            // If placing base tile, erase layer1 tile
            if (selectedTile.getLayer() == 0){
                lvl.getBase()[tileY][tileX] = selectedTile.getId();
                lvl.getBase2()[tileY][tileX] = -1;
            }
            // Place layer1 tile in layer1
            else {
                lvl.getBase2()[tileY][tileX] = selectedTile.getId();
            }
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        if (y >= 320){
            bottomBar.mouseMoved(x,y);
            drawSelect = false;
        }
        else {
            drawSelect = true;
            mouseX = (x / 32) * 32;
            mouseY = (y / 32) * 32;
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (y >= 320){
            bottomBar.mousePressed(x,y);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        bottomBar.mouseReleased(x,y);
    }

    public BottomBar getBottomBar() {
        return bottomBar;
    }

    @Override
    public void mouseDragged(int x, int y) {
        if (y >= 320){

        }
        else {
            changeTile(x,y);
        }
    }

    public void saveLevel() {
        LoadSave.saveLevel("defaultLevel",lvl);
        getGame().getPlay().setLvl(lvl);
    }
}