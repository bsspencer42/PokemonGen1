package Game;
import Inputs.KeyBoardListener;
import Inputs.MyMouseListener;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    private Dimension size;
    private Game game;
    private KeyBoardListener keyBoardListener;
    private MyMouseListener myMouseListener;

    public GameScreen(Game game){
        setPanelSize();
        this.game = game;
    }

    // Inputs
    public void initInputs(){
        keyBoardListener = new KeyBoardListener(game);
        myMouseListener = new MyMouseListener(game);

        addKeyListener(keyBoardListener);
        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        requestFocus();
    }

    private void setPanelSize() {
        this.size = new Dimension(480,320);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.getRender().render(g);
    }
}
