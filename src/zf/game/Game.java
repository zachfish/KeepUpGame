package zf.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Game extends JPanel implements ActionListener, KeyListener {
    private Frame frame;
    private Trampoline tramp;
    private Ball ball;
    private HashSet<Ball> ballSet = new HashSet<>();
    private Long time;
    private int score;




    public Game(Frame frame){
        Color niceBlue = new Color(38, 59, 102);
        setBackground(niceBlue);
        this.frame = frame;
        this.ball = new Ball(frame);
        ballSet.add(this.ball);
        int y = this.frame.getHeight() -125;
        this.tramp = new Trampoline(frame, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, y);
        this.score = 1;
        System.out.println(score);
        Timer timer = new Timer(5, this);
        timer.start();
        this.time = System.currentTimeMillis();
        addKeyListener(this);
        setFocusable(true);

    }

    public Trampoline getTramp(){
        return tramp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();

    }

    private void update(){
        Long newTime = System.currentTimeMillis();

        if (newTime - time >= 6000) {
            System.out.println(++this.score);
            Ball ball = new Ball(this.frame);
            ballSet.add(ball);
            time = newTime;

        }

        for (Ball b : ballSet){
             boolean bool = b.update();
        }
        
        tramp.update();

    }

    protected void setTime(Long time){
        this.time= time;

    }

    @Override
    public void keyPressed(KeyEvent e) {
        tramp.pressed(e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {
        tramp.released(e.getKeyCode());

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    Color trampColor = new Color(191, 170, 174);
    g.setColor(trampColor);
    tramp.paint(g);
    Color ballColor = new Color(250, 0, 170);
    g.setColor(ballColor);
    for (Ball b : ballSet){
        b.paint(g);
    }

    }



}
