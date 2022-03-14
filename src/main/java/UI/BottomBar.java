package UI;

import java.awt.*;

import static Game.GameStates.*;

public class BottomBar {

    private int x, y, width, height;
    private MyButton menu;

    public BottomBar(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initButtons();
    }

    private void initButtons() {
        menu = new MyButton("Menu", 15, 330, 100,30);
    }

    public void draw(Graphics g){
        // Background
        g.setColor(new Color(220,123,14));
        g.fillRect(x,y,width,height);
        // Buttons
        drawButtons(g);
    }

    private void drawButtons(Graphics g) {
        menu.draw(g);
    }

    // Mouse Interaction
    public void mouseClicked(int x, int y) {
        if (menu.getBounds().contains(x,y)){
            SetGameState(MENU);
        }
    }

    public void mouseMoved(int x, int y) {
        resetButtons();
        if (menu.getBounds().contains(x,y)){
            menu.setMouseOver(true);
        }
    }

    public void mousePressed(int x, int y) {
        if (menu.getBounds().contains(x,y)){
            menu.setMousePressed(true);
        }
    }

    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        menu.resetBooleans();
    }

}
