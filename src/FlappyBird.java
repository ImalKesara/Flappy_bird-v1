import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class FlappyBird extends JPanel implements ActionListener {
    int BoardWidth = 360;
    int BoardHeight = 640;

    //images
    Image backGroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    //bird
    int birdX = BoardWidth/8;
    int birdY = BoardHeight/2;
    int birdWidth  = 34;
    int birdHeight = 24;

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }


    class Bird{
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img){
            this.img = img;
        }

    }

    Bird bird;
    Timer gameLoop;

    int velocityY = -5;
//    int velocityYY = 5;
//    int velocityX = 3;
//    int velocityXX = -3;



    FlappyBird(){
        setPreferredSize(new Dimension(BoardWidth,BoardHeight));

        //load images
        backGroundImg = new ImageIcon(getClass().getResource("images/flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("images/flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("images/toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("images/bottompipe.png")).getImage();

        bird = new Bird(birdImg);

        gameLoop = new Timer(1000/16,this);
        gameLoop.start();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        System.out.println("draw");
        g.drawImage(backGroundImg,0,0,BoardWidth,BoardHeight,null);
        g.drawImage(bird.img,bird.x,bird.y,bird.width,bird.height,null);
    }

    public void move(){
        bird.y += velocityY;

    }
}
