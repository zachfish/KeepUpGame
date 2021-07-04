package zf.game;

import java.awt.Color;
import javax.swing.JFrame;

public class Frame extends JFrame {
    private final static int WIDTH = 1200, HEIGHT = 800;
    private Game game;


    public Frame(){
        setSize(WIDTH, HEIGHT);
        setTitle("KEEP UP");
     //   setBackground(customColor);
     //   getContentPane().setBackground(Color.BLACK);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        game = new Game(this);
        add(game);
        setVisible(true);
    }



    public Game getGame(){
        return game;
    }


    public static void main(String[] args) {
        new Frame();
    }


}
