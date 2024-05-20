import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random; //random places for pipes
import java.util.ArrayList; // for save pipes

public class FlappyBird extends JPanel{
    int BoardWidth = 360;
    int BoardHeight = 640;

    FlappyBird(){
        setPreferredSize(new Dimension(BoardWidth,BoardHeight));
        setBackground(Color.blue);
    }
}
