package nl.tudelft.jpacman.ui;

import javax.swing.*;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.ui.Map.AddMap;
import nl.tudelft.jpacman.ui.Map.MapPanel;
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
    private JPanel difPanel;
    private JLabel mapImage;
    private String bgPath = "origin";
    private ImageIcon scaledIcon;
    private JLabel img2;
    private int currentDif;
    private int currentMap =1 ;
    private JButton nextMapBtn;
    private JButton previousMapBtn;
    private JButton aboutBtn;
    private JFrame aboutFrame;

    private JButton difBtn1, difBtn2, difBtn3, difBtn4;

    private MapPanel mapPanel;


    public ConfigsUI() {
        setTitle("Custom Mode");
        setBounds(300, 0, 800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);

        ImageIcon logo1 = new ImageIcon("src/main/resources/sprite/logo.png");
        Image ch1 = logo1.getImage();
        Image scaledImage2 = ((Image) ch1).getScaledInstance(285,200,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        img2 = new JLabel(scaledIcon2);



        ImageIcon logo = new ImageIcon("src/main/resources/sprite/theme/"+bgPath+ "/bg.png");
        Image imagebg = logo.getImage();
        Image scaledImage = ((Image) imagebg).getScaledInstance(800,800,Image.SCALE_AREA_AVERAGING);
        scaledIcon = new ImageIcon(scaledImage);
        imgBg = new JLabel(scaledIcon);
        imgBg.setSize(800,800);

        ImageIcon imageIconStartBtn = new ImageIcon("src/main/resources/sprite/playbtn.png");
        Image startbtn = imageIconStartBtn.getImage();
        Image scaleImageStartBtn = ((Image) startbtn).getScaledInstance(200,100,Image.SCALE_SMOOTH);
        ImageIcon scaledImgStartBtn = new ImageIcon(scaleImageStartBtn);
        setStartBtn(new JButton(scaledImgStartBtn));
        getStartBtn().setBounds(300, 650, 200, 80);
        getStartBtn().setBorderPainted(false);

        ImageIcon imageIconBackBtn = new ImageIcon("src/main/resources/sprite/backbtn2.png");
        Image backbtn = imageIconBackBtn.getImage();
        Image scaleImageBackBtn = ((Image) backbtn).getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon scaledImgBackBtn = new ImageIcon(scaleImageBackBtn);
        backBtn = new JButton(scaledImgBackBtn);
        backBtn.setBounds(0, 0, 50, 50);
        backBtn.setBorderPainted(false);

        aboutBtn = new JButton(new ImageIcon("src/main/resources/sprite/about.png"));
        aboutBtn.setBounds(0, 720, 50, 50);
        aboutBtn.setBorderPainted(false);

        setThemePanel(new ThemePanel(AddThemeImages.getImages()));
        getThemePanel().setOpaque(true);
        getThemePanel().setBounds(50,150,360,440);

        difPanel = new JPanel();
        difPanel.setLayout(null);
        difPanel.setBounds(430,150,360,440);
       // difPanel.setBackground(Color.black);
        difPanel.setOpaque(false);

        difBtn1 = new JButton(new ImageIcon("src/main/resources/sprite/easyBtn.png"));
        difBtn2 = new JButton(new ImageIcon("src/main/resources/sprite/mediumBtn.png"));
        difBtn3 = new JButton(new ImageIcon("src/main/resources/sprite/hardBtn.png"));
        difBtn4 = new JButton(new ImageIcon("src/main/resources/sprite/superhardBtn.png"));
        img2.setBounds(40,-50,285,200);
        int distance = 40;
        difBtn1.setBounds(distance,100,70,70);
        difBtn2.setBounds(distance+70,100,70,70);
        difBtn3.setBounds(distance+140,100,70,70);
        difBtn4.setBounds(distance+210,100,70,70);

//        setMapPanel(new MapPanel(AddMap.getMaps()));
//        getMapPanel().setOpaque(true);
//        getMapPanel().setBounds(60,200,240,240);

        difBtn1.setBorderPainted(false);
        difBtn2.setBorderPainted(false);
        difBtn3.setBorderPainted(false);
        difBtn4.setBorderPainted(false);

        mapImage = new JLabel(new ImageIcon("src/main/resources/sprite/map/map1.png"));
        mapImage.setBounds(60,200,240,240);

        nextMapBtn = new JButton(new ImageIcon("src/main/resources/sprite/nextMapBtn.png"));
        nextMapBtn.setBounds(315,300,40,40);
        nextMapBtn.setBorderPainted(false);

        previousMapBtn = new JButton(new ImageIcon("src/main/resources/sprite/previousMapBtn.png"));
        previousMapBtn.setBounds(0,300,40,40);
        previousMapBtn.setBorderPainted(false);

        nextMapBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setCurrentMap(getCurrentMap() + 1);
                if (getCurrentMap() > 5){
                    setCurrentMap(1);
                }
                mapImage.setIcon(new ImageIcon("src/main/resources/sprite/map/map"+getCurrentMap()+".png"));
                repaint();
                System.out.println(getCurrentMap());
            }
        });

        previousMapBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setCurrentMap(getCurrentMap() - 1);

                if (getCurrentMap() <= 0){
                    setCurrentMap(5);
                }
                mapImage.setIcon(new ImageIcon("src/main/resources/sprite/map/map"+getCurrentMap()+".png"));
                repaint();
                System.out.println(getCurrentMap());
            }
        });

        difPanel.add(img2);
        difPanel.add(difBtn1);
        difPanel.add(difBtn2);
        difPanel.add(difBtn3);
        difPanel.add(difBtn4);
//        difPanel.add(getMapPanel());
        difPanel.add(mapImage);
        difPanel.add(nextMapBtn);
        difPanel.add(previousMapBtn);

        this.add(backBtn);
        this.add(aboutBtn);
        this.add(getStartBtn());
        this.add(getThemePanel());
        this.add(difPanel);
        this.add(imgBg);

        aboutBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                aboutFrame = new JFrame();
                aboutFrame.setLayout(null);
                aboutFrame.setBounds(300,0,500,500);
                aboutFrame.setVisible(true);
                JLabel imgAbout = new JLabel(new ImageIcon("src/main/resources/sprite/Game Difficulty.png"));
                imgAbout.setSize(new Dimension(500,500));
                aboutFrame.add(imgAbout);
            }
        });
        difBtn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                currentDif = 1;
                difBtn1.setEnabled(false);
                difBtn2.setEnabled(true);
                difBtn3.setEnabled(true);
                difBtn4.setEnabled(true);
            }
        });
        difBtn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                currentDif = 2;
                difBtn1.setEnabled(true);
                difBtn2.setEnabled(false);
                difBtn3.setEnabled(true);
                difBtn4.setEnabled(true);
            }
        });
        difBtn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                currentDif = 3;
                difBtn1.setEnabled(true);
                difBtn2.setEnabled(true);
                difBtn3.setEnabled(false);
                difBtn4.setEnabled(true);
            }
        });
        difBtn4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                currentDif = 4;
                difBtn1.setEnabled(true);
                difBtn2.setEnabled(true);
                difBtn3.setEnabled(true);
                difBtn4.setEnabled(false);
            }
        });


        getThemePanel().getNextButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
        getThemePanel().getPreviousButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
        getStartBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                getThemePanel().startGame(getCurrentDifficulty(),getCurrentMap());
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

    public ThemePanel getThemePanel() {
        return themePanel;
    }

    public void setThemePanel(ThemePanel themePanel) {
        this.themePanel = themePanel;
    }

    public void setMapPanel(MapPanel mapPanel) { this.mapPanel = mapPanel; }

    public MapPanel getMapPanel() { return mapPanel; }

    public JButton getStartBtn() {
        return startBtn;
    }

    public void setStartBtn(JButton startBtn) {
        this.startBtn = startBtn;
    }

    public void setCurrentMap(int c){this.currentMap = c;}

    public int getCurrentMap(){return this.currentMap;}
    public void setPanelBackground(){
        bgPath = themePanel.getCurrentThemeName();
        ImageIcon bg = new ImageIcon("src/main/resources/sprite/theme/" + bgPath + "/bg.png");
        imgBg.setIcon(bg);
        repaint();
    }

    public String getCurrentDifficulty() {
        if (currentDif == 1) {
            return "Easy";
        } else if (currentDif == 3) {
            return "Hard";
        } else if (currentDif == 4) {
            return "Super Hard";
        } else {
            return "Medium";
        }
    }

    public JButton getEasyDifBtn() {
        return difBtn1;
    }

    public JButton getMediumDifBtn() {
        return difBtn2;
    }

    public JButton getHardDifBtn() {
        return difBtn3;
    }

    public JButton getSuperHardDifBtn() {
        return difBtn4;
    }
}
