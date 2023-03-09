package nl.tudelft.jpacman.ui;

import java.awt.*;
import javax.swing.*;

public class SelectConfigureUI extends JFrame{

    public SelectConfigureUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setTitle("Pacman");
        this.getContentPane().setBackground(new Color(0x00195f));
        this.setLayout(new FlowLayout());

        // JPanel defaultPanel = new JPanel();
        // defaultPanel.setPreferredSize(new Dimension(600,600));

        JPanel head = new JPanel();
        JLabel choose = new JLabel("CHOOSE");
        // JLabel imgLabel = new JLabel(new ImageIcon("src/main/resources/sprite/pMan.png"));
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(new ImageIcon(new ImageIcon("icon.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        // head.setBackground(Color.orange);
        choose.setFont(new Font("Sans-Serif", Font.PLAIN, 60));
        head.setPreferredSize(new Dimension(800, 100));
        head.add(imgLabel);
        head.add(choose);

        JPanel configs = new JPanel();
        // configs.setBackground(Color.GREEN);
        configs.setPreferredSize(new Dimension(800, 400));
        configs.setLayout(new FlowLayout());
        
        JPanel subconfigs1 = new JPanel();
        subconfigs1.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        subconfigs1.setPreferredSize(new Dimension(800,200));
        subconfigs1.setBackground(Color.green);
        JButton previousLevel = new JButton("<<<");
        JLabel image = new JLabel("Level of difficulty");
        JButton nextLevel = new JButton(">>>");
        subconfigs1.add(previousLevel);
        subconfigs1.add(image);
        subconfigs1.add(nextLevel);

        JPanel subconfigs2 = new JPanel();
        subconfigs2.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        subconfigs2.setPreferredSize(new Dimension(800,200));
        subconfigs2.setBackground(Color.red);
        JButton previousTheme = new JButton("<<<");
        JLabel image1 = new JLabel("Image of theme");
        JButton nextTheme = new JButton(">>>");
        subconfigs2.add(previousTheme);
        subconfigs2.add(image1);
        subconfigs2.add(nextTheme);

        configs.add(subconfigs1);
        configs.add(subconfigs2);

        // configs.add(previousLevel);
        // configs.add(image);
        // configs.add(nextLevel);

        // configs.add(previousTheme);
        // configs.add(image1);
        // configs.add(nextTheme);

        JPanel confirm = new JPanel();
        // confirm.setBackground(Color.RED);
        confirm.setPreferredSize(new Dimension(800, 100));
        confirm.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 5));

        JButton confirmButton = new JButton("Confirm");
        JButton backButton = new JButton("Back");

        confirm.add(confirmButton);
        confirm.add(backButton);

        this.add(head);
        this.add(configs);
        this.add(confirm);   
    }

    public void start(){
        setVisible(true);
    }
}
