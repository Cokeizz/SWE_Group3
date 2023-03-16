package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.sprite.SpriteStore;

import javax.swing.*;
import javax.swing.Action;
import java.awt.*;
import java.awt.event.*;

public class HomeUI
    extends JFrame
    implements ActionListener {

    Launcher launcher = new Launcher();
    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JLabel img;
    private JLabel img2;

    private JButton startBtn;
    private JButton settingBtn;


    private JButton redButton;


    public HomeUI()
    {

        setTitle("Home");
        setBounds(300, 0, 800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        /*name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);*/

        ImageIcon imageIconStartBtn = new ImageIcon("src/main/resources/sprite/startbtn.png");
        Image startbtn = imageIconStartBtn.getImage();
        Image scaledImageStartBtn = ((Image) startbtn).getScaledInstance(253,112,Image.SCALE_SMOOTH);
        ImageIcon scaledImgStartBtn = new ImageIcon(scaledImageStartBtn);
        startBtn = new JButton(scaledImgStartBtn);
        startBtn.setBounds(280, 350, 253, 90);
        startBtn.setBorderPainted(false);
        c.add(startBtn);

        ImageIcon imageIconSettingtBtn = new ImageIcon("src/main/resources/sprite/settingbtn.png");
        Image settingbtn = imageIconSettingtBtn.getImage();
        Image scaledImageSettingBtn = ((Image) settingbtn).getScaledInstance(253,100,Image.SCALE_SMOOTH);
        ImageIcon scaledImgSettingBtn = new ImageIcon(scaledImageSettingBtn);
        settingBtn = new JButton(scaledImgSettingBtn);
        settingBtn.setBounds(280, 480, 253, 90);
        settingBtn.setBorderPainted(false);
        c.add(settingBtn);

        ImageIcon logo1 = new ImageIcon("src/main/resources/sprite/logo.png");
        Image ch1 = logo1.getImage();
        Image scaledImage2 = ((Image) ch1).getScaledInstance(585,360,Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        img2 = new JLabel(scaledIcon2);
        img2.setSize(1920,1080);
        img2.setLocation(-550,-400);
        c.add(img2);

        ImageIcon logo = new ImageIcon("src/main/resources/sprite/bg.png");
        Image image = logo.getImage();
        Image scaledImage = ((Image) image).getScaledInstance(1920,1080,Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        img = new JLabel(scaledIcon);
        img.setSize(1920,1080);
        img.setLocation(-550,-240);
        c.add(img);

        startBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                launcher.launchConfigure();
                setVisible(false);
            }
        });
        settingBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SettingUI s1 = new SettingUI();
                setVisible(false);
            }
        });


        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {

    }
}
