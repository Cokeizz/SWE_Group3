package nl.tudelft.jpacman.ui;
import javax.swing.*;
import java.awt.*;
public class testGui extends JFrame{
    public testGui(){
//        JFrame frame = new JFrame("My First GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,300);
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        this.getContentPane().add(button1);
        this.getContentPane().add(button2);
        this.setVisible(true);
    }

    public void start(){
        setVisible(true);
    }

}

