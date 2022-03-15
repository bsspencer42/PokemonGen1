package UI;

import java.awt.*;

public class MyButton {
    private int x;
    private int y;
    private int width;
    private int height;
    private int id;
    private String text;
    private Rectangle bounds;
    private boolean mouseOver,mousePressed;

    // Normal buttons
    public MyButton(String text, int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this. height = height;
        this.text = text;
        this.id = -1;
        initBounds();
    }

    // Tile buttons
    public MyButton(String text, int x, int y, int width, int height, int id){
        this.x = x;
        this.y = y;
        this.width = width;
        this. height = height;
        this.text = text;
        this.id = id;
        initBounds();
    }


    private void initBounds(){
        this.bounds = new Rectangle(x,y,width,height);
    }

    // Draw Methods
    public void draw(Graphics g){
        // Body
        drawBody(g);
        // Border
        drawBorder(g);
        // Text
        drawText(g);
    }

    private void drawBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(x,y,width,height);
        if (mousePressed){
            g.drawRect(x+1,y+1,width-2,height-2);
            g.drawRect(x+2,y+2,width-4,height-4);
        }
    }

    private void drawBody(Graphics g) {
        if (mouseOver){
            g.setColor(Color.gray);
        }
        else {
            g.setColor(Color.WHITE);
        }
        g.fillRect(x,y,width,height);
    }

    private void drawText(Graphics g) {
        int w = g.getFontMetrics().stringWidth(text);
        int h = g.getFontMetrics().getHeight();
        g.drawString(text, x - w / 2 + width / 2, y + h / 2 + height / 2 - 3);
    }

    // Mouse IO
    public void setMouseOver(boolean mouseOver){
        this.mouseOver = mouseOver;
    }

    public void setMousePressed(boolean mousePressed){
        this.mousePressed = mousePressed;
    }

    public boolean isMouseOver(){
        return mouseOver;
    }

    public boolean isMousePressed(){
        return mousePressed;
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void resetBooleans(){
        this.mouseOver = false;
        this.mousePressed = false;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
