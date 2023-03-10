package nl.tudelft.jpacman.ui;

import javax.swing.*;

import nl.tudelft.jpacman.ui.Theme.AddThemeImages;
import nl.tudelft.jpacman.ui.Theme.ThemePanel;

import java.awt.*;

public class ConfigsUI extends JFrame{

    // private JPanel themePanel;
    private JLabel imgBg;

    public ConfigsUI() {
        setTitle("Home");
        setBounds(300, 0, 800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLayout(new BorderLayout());

        // Add Background image
        // ImageIcon logo = new ImageIcon("src/main/resources/sprite/bg.png");
        // Image imagebg = logo.getImage();
        // Image scaledImage = ((Image) imagebg).getScaledInstance(1920,1080,Image.SCALE_AREA_AVERAGING);
        // ImageIcon scaledIcon = new ImageIcon(scaledImage);
        // imgBg = new JLabel(scaledIcon);
        // imgBg.setSize(1920,1080);

        // //Text heading choose
        // ImageIcon tmpChooseBand = new ImageIcon("src/main/resources/sprite/chooseband.png");
        // Image chooseBandLabel = tmpChooseBand.getImage();
        // Image scaleChooseBandLabel = ((Image) chooseBandLabel).getScaledInstance(253,112,Image.SCALE_SMOOTH);
        // ImageIcon scaledChooseBandLabel = new ImageIcon(scaleChooseBandLabel);
        // JLabel choose = new JLabel(scaledChooseBandLabel);
        // choose.setSize(1920,960);
        // choose.setLocation(-565,-400);

        //Back button
        // ImageIcon imageIconBackBtn = new ImageIcon("src/main/resources/sprite/backbtn2.png");
        // Image backbtn = imageIconBackBtn.getImage();
        // Image scaleImageBackBtn = ((Image) backbtn).getScaledInstance(50,50,Image.SCALE_SMOOTH);
        // ImageIcon scaledImageBackBtn = new ImageIcon(scaleImageBackBtn);
        // backHomeBtn = new JButton(scaledImageBackBtn);
        // backHomeBtn.setBounds(0, 0, 50, 50);

        // ImageIcon imageIconStartBtn = new ImageIcon("src/main/resources/sprite/playbtn.png");
        // Image startbtn = imageIconStartBtn.getImage();
        // Image scaleImageStartBtn = ((Image) startbtn).getScaledInstance(200,100,Image.SCALE_SMOOTH);
        // ImageIcon scaledImgStartBtn = new ImageIcon(scaleImageStartBtn);
        // startBtn = new JButton(scaledImgStartBtn);
        // startBtn.setBounds(300, 650, 200, 80);

        // Border blackline = BorderFactory.createTitledBorder("Choose Theme");

        ThemePanel themePanel = new ThemePanel(AddThemeImages.getImages());

        // themePanel = new JPanel();
        // themePanel.setBounds(200,150,400,480);
        // themePanel.setBackground(Color.orange);
        // themePanel.setBorder(blackline);

        // this.add(startBtn);
        // this.add(backHomeBtn);
        this.add(themePanel);

        // this.add(choose, BorderLayout.NORTH);
        
    }

    public void start() {
        setVisible(true);
    }
}
