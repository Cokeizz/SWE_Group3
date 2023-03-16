package nl.tudelft.jpacman.ui;

import javax.swing.*;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.ui.Theme.AddThemeImages;
import nl.tudelft.jpacman.ui.Theme.Theme;
import nl.tudelft.jpacman.ui.Theme.ThemePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConfigsUI extends JFrame implements ActionListener {

    // private JPanel themePanel;

    private ArrayList<Theme> themeImages;
    private JLabel imgBg;
    private JButton startBtn;
    private Launcher startGame;
    private PacManSprites sprite;
    private int currentThemeImageIndex;
    private ThemePanel themePanel;
    private JButton backBtn;

    public ConfigsUI() {
        setTitle("Customize");
        setBounds(300, 0, 800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);


        ImageIcon logo = new ImageIcon("src/main/resources/sprite/bg.png");
        Image imagebg = logo.getImage();
        Image scaledImage = ((Image) imagebg).getScaledInstance(800,800,Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imgBg = new JLabel(scaledIcon);
        imgBg.setSize(800,800);
        imgBg.setLocation(0,0);

        ImageIcon imageIconStartBtn = new ImageIcon("src/main/resources/sprite/playbtn.png");
        Image startbtn = imageIconStartBtn.getImage();
        Image scaleImageStartBtn = ((Image) startbtn).getScaledInstance(200,100,Image.SCALE_SMOOTH);
        ImageIcon scaledImgStartBtn = new ImageIcon(scaleImageStartBtn);
        startBtn = new JButton(scaledImgStartBtn);
        startBtn.setBounds(300, 650, 200, 80);
        startBtn.setBorderPainted(false);

        ImageIcon imageIconBackBtn = new ImageIcon("src/main/resources/sprite/backbtn2.png");
        Image backbtn = imageIconBackBtn.getImage();
        Image scaleImageBackBtn = ((Image) backbtn).getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon scaledImgBackBtn = new ImageIcon(scaleImageBackBtn);
        backBtn = new JButton(scaledImgBackBtn);
        backBtn.setBounds(0, 0, 50, 50);
        backBtn.setBorderPainted(false);

        themePanel = new ThemePanel(AddThemeImages.getImages());

        themePanel.setOpaque(true);
        themePanel.setBounds(200,150,400,480);


        this.add(backBtn);
        this.add(startBtn);
        this.add(themePanel);
        this.add(imgBg);



        startBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                themePanel.startGame();
            }
        });

        backBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                Launcher l2 = new Launcher();
                l2.launchHome();
            }
        });
    }
    public void start() {
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        }
    }

