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

    public ConfigsUI() {
        setTitle("Customize");
        setBounds(300, 0, 800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(null);

        ImageIcon logo = new ImageIcon("src/main/resources/sprite/theme/"+bgPath+ "/bg.png");
        Image imagebg = logo.getImage();
        Image scaledImage = ((Image) imagebg).getScaledInstance(800,800,Image.SCALE_AREA_AVERAGING);
        scaledIcon = new ImageIcon(scaledImage);
        imgBg = new JLabel(scaledIcon);
        imgBg.setSize(800,800);
        imgBg.setLocation(0,0);


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
        getThemePanel().setBounds(30,150,360,440);


        difPanel = new JPanel();
        difPanel.setBounds(400,150,360,200);
        difPanel.setBackground(Color.orange);

        mapPanel = new JPanel();
        mapPanel.setBounds(400,370,360,200);
        mapPanel.setBackground(Color.orange);

        this.add(backBtn);
        this.add(getStartBtn());
        this.add(getThemePanel());
        this.add(difPanel);
        this.add(mapPanel);
        this.add(imgBg);

        getThemePanel().getNextButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setPanelBackground();
            }
        });
        getThemePanel().getPreviousButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setPanelBackground();
            }
        });
        getStartBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                getThemePanel().startGame();
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


}
