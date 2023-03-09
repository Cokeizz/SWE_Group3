package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingUI
    extends JFrame
    implements ActionListener {

    private Container c;
    private JLabel img;

    private JButton backBtn;

    SettingUI(){
        setTitle("Setting");
        setBounds(300, 0, 800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);
        ImageIcon imageIconStartBtn = new ImageIcon("src/main/resources/sprite/backbtn.png");
        Image startbtn = imageIconStartBtn.getImage();
        Image scaledImageStartBtn = ((Image) startbtn).getScaledInstance(253,112,Image.SCALE_SMOOTH);
        ImageIcon scaledImgStartBtn = new ImageIcon(scaledImageStartBtn);
        backBtn = new JButton(scaledImgStartBtn);
        backBtn.setBounds(280, 350, 250, 90);
        c.add(backBtn);

        ImageIcon logo = new ImageIcon("src/main/resources/sprite/bg.png");
        Image image = logo.getImage();
        Image scaledImage = ((Image) image).getScaledInstance(1920,1080,Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        img = new JLabel(scaledIcon);
        img.setSize(1920,1080);
        img.setLocation(-550,-240);
        c.add(img);



        setVisible(true);

        backBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new HomeUI().setVisible(true);
                setVisible(false);
            }
        });


    }








    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
