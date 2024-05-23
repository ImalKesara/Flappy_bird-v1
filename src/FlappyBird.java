import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    int BoardWidth = 360;
    int BoardHeight = 640;


    Random random = new Random();
    Timer gameLoop;
    Timer placePipesTimer;
    Bird bird;
    ArrayList<Pipe> pipes;


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
    int velocityY = 0;
    int gravity  = 1;
    int velocityX = -4;

    //pipe
    int pipeX = BoardWidth;
    int pipeY = 0;
    int pipewidth = 64;
    int pipeheight  = 512;

    public class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img){
            this.img = img;
        }
    }

    class Pipe{
        int x = pipeX;
        int y = pipeY;
        int width = pipewidth;
        int height = pipeheight;
        Image img;
        boolean passed = false; //track pipe passed or not

        Pipe(Image img){
            this.img  = img;
        }
    }

    FlappyBird(){
        setPreferredSize(new Dimension(BoardWidth,BoardHeight));
        setFocusable(true);
        addKeyListener(this);

        //load images
        backGroundImg = new ImageIcon(getClass().getResource("images/flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("images/flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("images/toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("images/bottompipe.png")).getImage();

        bird = new Bird(birdImg);
        pipes = new ArrayList<Pipe>();

        gameLoop = new Timer(1000/16,this);
        placePipesTimer = new Timer(1500,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                placepipes();
            }
        });
        placePipesTimer.start();
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
        for(int i =0;i< pipes.size() ; i++){
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.img,pipe.x,pipe.y,pipe.width,pipe.height,null);
        }
    }

    public void move(){
        velocityY += gravity;
        bird.y += velocityY;
        bird.y = Math.max(bird.y, 0);

        for (int i =0; i < pipes.size() ;i ++){
            Pipe pipe = pipes.get(i);
            pipe.x += velocityX;
        }
    }

    public void placepipes(){
        int randomPipeY = (int)(pipeY - pipeheight/4 - Math.random()*(pipeheight/2));
        Pipe topPipe = new Pipe(topPipeImg);
        topPipe.y = randomPipeY;
        pipes.add(topPipe);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            velocityY = -5;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
}
