//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        int BoardWidth = 360;
        int BoardHeight = 640;

        FlappyBird flappyBird = new FlappyBird();
        JFrame frame =  new JFrame("Flappy bird");
        frame.setSize(BoardWidth,BoardHeight);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(flappyBird);
        frame.pack();


    }
}