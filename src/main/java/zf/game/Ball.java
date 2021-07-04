package zf.game;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JOptionPane;


public class Ball {
    private static final int WIDTH = 30, HEIGHT = 30;
    private Frame frame;
    private int x , y, xa = 3, ya = 3;



    public Ball (Frame frame){
        this.frame=frame;
        this.x = (int) (Math.random() * frame.getWidth());
        this.y = (int) (Math.random() * (frame.getHeight()/5));

    }

    public Boolean update(){
        x+=xa;
        y+=ya;

        if (y>=frame.getHeight()){
           JOptionPane.showMessageDialog(null, "You Lost", "Keep Up", JOptionPane.PLAIN_MESSAGE);
            this.x = frame.getWidth() / 2;
            this.y = 10;
            return false;
        }

        if (x < 0 || x > frame.getWidth() - 10){
            xa = -xa;

        }
        if (y < 0){
            ya = - ya;
        }

        checkCollision();
        return true;

    }



    public void checkCollision(){
        if (frame.getGame().getTramp().getBounds().intersects(getBounds())){
            ya=-ya;
        }


    }



    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, HEIGHT);

    }

    public void paint (Graphics g){
        g.fillRect(x, y, WIDTH, HEIGHT);
    }


}
