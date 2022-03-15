package Scenes;

import Game.Game;
import Objects.Tile;
import UI.BottomBar;
import helpz.LevelBuild;
import helpz.LoadSave;

import java.awt.*;

public class WorldEditor extends GameScene {
    private int[][] lvl;
    private BottomBar bottomBar;
    private Tile selectedTile;
    private int mouseX, mouseY;
    private int lastTileX, lastTileY, lastTileId;
    private boolean drawSelect;

    public WorldEditor(Game game) {
        super(game,480, 420);
        // Load Edit bar
        bottomBar = new BottomBar(0,320,480,100,getGame());
        // Load Default level
        loadDefaultLevel();
    }

    private void loadDefaultLevel() {
        lvl = LoadSave.getLevelData("new level");
    }

    private void createDefaultLevel() {
        int[] arr = new int[150];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        LoadSave.CreateLevel("new level",arr);
    }

    @Override
    public void render(Graphics g) {
        for (int y = 0; y < lvl.length; y++) {
            for (int x = 0; x < lvl[y].length; x++) {
                int id = lvl[y][x];
                g.drawImage(super.getGame().getSprites().get(lvl[y][x]).getSprite(), x * 32, y * 32, null);
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
            lvl[tileY][tileX] = selectedTile.getId();
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
        LoadSave.saveLevel("new level",lvl);
    }
}