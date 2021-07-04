package zf.game;

import java.awt.*;

public class Trampoline {
    private static final int WIDTH =500, HEIGHT = 50;
    private Frame frame;
    private int left, right, x, y;
    private int move;


    public Trampoline (Frame frame, int left, int right, int y){
        this.frame = frame;
        this. left = left;
        this.right = right;
        this.y = y;
        this.x= (frame.getWidth() / 2) - (WIDTH /2); // check this
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, HEIGHT);

    }

    public void paint (Graphics g){
        g.fillRect(x, y, WIDTH, HEIGHT);
    }


    public void pressed(int keyCode){
        if (keyCode == left){
            move = -3;
        } else if (keyCode == right){
            move = +3;
        }

    }

    public void released(int keyCode){
        if (keyCode == left || keyCode == right){
            move = 0;
        }

    }

    public void update(){  // have to fic this a little
       if ( x > 0 && x < frame.getWidth() - WIDTH){
            x += move;
        } else if (x <= 3 ){
            x++;
        } else if (x > frame.getWidth()- WIDTH -3){
            x--;
        }

    }







}
