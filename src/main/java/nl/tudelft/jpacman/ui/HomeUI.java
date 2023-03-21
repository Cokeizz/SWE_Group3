package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.sprite.SpriteStore;

import javax.swing.*;
import javax.swing.Action;
import java.awt.*;
import java.awt.event.*;

public class HomeUI
    extends JFrame
    implements ActionListener {

    Launcher launcher = new Launcher();

    private PacManSprites sprite;
    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JLabel img;
    private JLabel img2;

    private JButton startBtn;
    private JButton startAdventureBtn;
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

        ImageIcon imageIconStartBtn = new ImageIcon("src/main/resources/sprite/customModeBtn.png");
        Image startbtn = imageIconStartBtn.getImage();
        Image scaledImageStartBtn = ((Image) startbtn).getScaledInstance(300,75,Image.SCALE_SMOOTH);
        ImageIcon scaledImgStartBtn = new ImageIcon(scaledImageStartBtn);
        startBtn = new JButton(scaledImgStartBtn);
        startBtn.setBounds(200, 510, 400, 100);
        startBtn.setBorderPainted(false);
        c.add(startBtn);

        ImageIcon imageIconStartAdventureBtn = new ImageIcon("src/main/resources/sprite/adventureModeBtn.png");
        Image startadventurebtn = imageIconStartAdventureBtn.getImage();
        Image scaledImageStartAdventureBtn = ((Image) startadventurebtn).getScaledInstance(300,75,Image.SCALE_SMOOTH);
        ImageIcon scaledImgStartAdventureBtn = new ImageIcon(scaledImageStartAdventureBtn);
        startAdventureBtn = new JButton(scaledImgStartAdventureBtn);
        startAdventureBtn.setBounds(200, 600, 400, 100);
        startAdventureBtn.setBorderPainted(false);
        c.add(startAdventureBtn);

        JLabel bgBtn = new JLabel(new ImageIcon("src/main/resources/sprite/bgBtn.png"));
        bgBtn.setBounds(235, 500, 330, 209);
        c.add(bgBtn);

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
        Image scaledImage = ((Image) image).getScaledInstance(800,800,Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        img = new JLabel(scaledIcon);
        img.setSize(800,800);
        img.setLocation(0,0);
        c.add(img);

        startBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                launcher.launchConfigure();
                setVisible(false);
            }
        });

        startAdventureBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sprite = new PacManSprites();
                String path = "love";
                sprite.setGhostPath(path);
                sprite.setPacmanPath(path);
                sprite.setWallPath(path);
                sprite.setGroundPath(path);
                sprite.setPelletPath(path);
                launcher.setPacmanSprites(sprite);
                launcher.setLevelGhostFactory("4");
                launcher.setMap("/0.txt");
                launcher.launchAdventure();
                setVisible(false);
            }
        });

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {

    }
}
