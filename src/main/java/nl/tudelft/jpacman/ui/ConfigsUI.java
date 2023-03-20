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
    private JPanel difPanel;
    private JPanel mapPanel;
    private String bgPath = "origin";
    private ImageIcon scaledIcon;
    private JLabel img2;
    private int currentDif;


    public ConfigsUI() {
        setTitle("Customize");
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

        setThemePanel(new ThemePanel(AddThemeImages.getImages()));
        getThemePanel().setOpaque(true);
        getThemePanel().setBounds(50,150,360,440);

        difPanel = new JPanel();
        difPanel.setLayout(null);
        difPanel.setBounds(430,150,360,440);
       // difPanel.setBackground(Color.black);
        difPanel.setOpaque(false);

        JButton difBtn1 = new JButton(new ImageIcon("src/main/resources/sprite/easyBtn.png"));
        JButton difBtn2 = new JButton(new ImageIcon("src/main/resources/sprite/mediumBtn.png"));
        JButton difBtn3 = new JButton(new ImageIcon("src/main/resources/sprite/hardBtn.png"));
        JButton difBtn4 = new JButton(new ImageIcon("src/main/resources/sprite/superhardBtn.png"));
        img2.setBounds(40,-50,285,200);
        int distance = 40;
        difBtn1.setBounds(distance,100,70,70);
        difBtn2.setBounds(distance+70,100,70,70);
        difBtn3.setBounds(distance+140,100,70,70);
        difBtn4.setBounds(distance+210,100,70,70);

        difPanel.add(img2);
        difPanel.add(difBtn1);
        difPanel.add(difBtn2);
        difPanel.add(difBtn3);
        difPanel.add(difBtn4);



        this.add(backBtn);
        this.add(getStartBtn());
        this.add(getThemePanel());
        this.add(difPanel);
        this.add(imgBg);


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
                getThemePanel().startGame(getCurrentDifficulty());
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

    public JButton getStartBtn() {
        return startBtn;
    }

    public void setStartBtn(JButton startBtn) {
        this.startBtn = startBtn;
    }
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
}
