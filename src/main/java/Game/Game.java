package Game;

import DAO.SpriteDAO;
import Scenes.Battle;
import Scenes.Menu;
import Scenes.Play;
import Objects.Tile;
import Scenes.WorldEditor;

import javax.swing.*;
import java.util.ArrayList;

public class Game extends JFrame implements Runnable {
    // Instance Variables
    private GameScreen gameScreen;
    private ArrayList<Tile> sprites;
    private Render render;
    private Menu menu;
    private Battle battle;
    private Play play;
    private WorldEditor worldEditor;

    // Threading
    private Thread gameThread;
    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    public Game(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        initClasses();
        // Setup Screen
        add(gameScreen);
        pack();
        setVisible(true);
    }

    private void initClasses() {
        this.render = new Render(this);
        gameScreen = new GameScreen(this);
        sprites = new SpriteDAO().getTileSet();
        menu = new Menu(this);
        battle = new Battle(this);
        play = new Play(this);
        worldEditor = new WorldEditor(this);
    }

    private void updateGame() {
        // Nothing for now
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.gameScreen.initInputs();
        game.start();
    }

    private void start() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {
        long lastFrame  = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();
        double timePerFrame = 1000000000.0 /FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        int frames = 0;
        int updates = 0;
        long now;

        while (true){
            now = System.nanoTime();
            // Render
            if (now - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = now;
                frames++;
            }
            // Update
            if (now - lastUpdate >= timePerUpdate){
                updateGame();
                lastUpdate = now;
                updates++;
            }
            // Frames and Update updates
            if (System.currentTimeMillis() - lastTimeCheck >= 1000){
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }

    // Getters and setters
    public Render getRender(){
        return this.render;
    }
    public Menu getMenu() {
        return menu;
    }
    public Battle getBattle() {
        return battle;
    }
    public Play getWorld() {
        return play;
    }
    public Play getPlay() {
        return play;
    }
    public WorldEditor getWorldEditor(){
        return worldEditor;
    }
    public ArrayList<Tile> getSprites(){
        return sprites;
    }
    public GameScreen getGameScreen() {
        return gameScreen;
    }
}
