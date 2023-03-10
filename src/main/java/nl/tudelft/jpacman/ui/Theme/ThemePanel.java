package nl.tudelft.jpacman.ui.Theme;

import javax.swing.*;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.sprite.Sprite;
import nl.tudelft.jpacman.ui.HomeUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ThemePanel extends JPanel implements ActionListener{

    private JLabel imgBg;

    private JPanel buttonPanel;

    private JLabel choose;
    private JButton backHomeBtn;
    private JButton startBtn;

    private ArrayList<Theme> themeImages;
    private int currentThemeImageIndex;
    private JLabel themeLabel;

    private Launcher startGame;
    private PacManSprites sprite;

    public ThemePanel(ArrayList<Theme> themes) {
        this.themeImages = themes;

        // setBounds(200,150,400,480);
        // setBackground(Color.orange);
        setLayout(new BorderLayout());
        // setBorder(blackline);

        ImageIcon logo = new ImageIcon("src/main/resources/sprite/bg.png");
        Image imagebg = logo.getImage();
        Image scaledImage = ((Image) imagebg).getScaledInstance(1920,1080,Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imgBg = new JLabel(scaledIcon);
        imgBg.setBounds(0, 0, 1920, 1080);

        JPanel bgPanel = new JPanel();
        bgPanel.setLayout(null);
        bgPanel.add(imgBg);
        // bgPanel.setOpaque(false);

        //Text heading choose
        ImageIcon tmpChooseBand = new ImageIcon("src/main/resources/sprite/chooseband.png");
        Image chooseBandLabel = tmpChooseBand.getImage();
        Image scaleChooseBandLabel = ((Image) chooseBandLabel).getScaledInstance(253,112,Image.SCALE_SMOOTH);
        ImageIcon scaledChooseBandLabel = new ImageIcon(scaleChooseBandLabel);
        choose = new JLabel(scaledChooseBandLabel);
        choose.setSize(1920,960);

        ImageIcon imageIconBackBtn = new ImageIcon("src/main/resources/sprite/backbtn2.png");
        Image backbtn = imageIconBackBtn.getImage();
        Image scaleImageBackBtn = ((Image) backbtn).getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon scaledImageBackBtn = new ImageIcon(scaleImageBackBtn);
        backHomeBtn = new JButton(scaledImageBackBtn);
        backHomeBtn.setBounds(0, 0, 50, 50);
        backHomeBtn.addActionListener(this);

        ImageIcon imageIconStartBtn = new ImageIcon("src/main/resources/sprite/playbtn.png");
        Image startbtn = imageIconStartBtn.getImage();
        Image scaleImageStartBtn = ((Image) startbtn).getScaledInstance(200,100,Image.SCALE_SMOOTH);
        ImageIcon scaledImgStartBtn = new ImageIcon(scaleImageStartBtn);
        startBtn = new JButton(scaledImgStartBtn);
        startBtn.setBounds(300, 650, 200, 80);
        startBtn.addActionListener(this);

        //Get theme items in list
        currentThemeImageIndex = 0;

        // Create the image label and set the first image
        themeLabel = new JLabel();
        themeLabel.setIcon(themes.get(currentThemeImageIndex).getIcon());
        themeLabel.setHorizontalAlignment(JLabel.CENTER);

        // Create the previous and next buttons
        JButton previousButton = new JButton("Previous");
        previousButton.addActionListener(this);
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(this);

        buttonPanel = new JPanel();
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        buttonPanel.setOpaque(false);

        // Create panels for different sections
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        topPanel.add(backHomeBtn);
        topPanel.add(choose);

        centerPanel.add(themeLabel, BorderLayout.CENTER);
        centerPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add components to panels
        bottomPanel.add(startBtn);

        topPanel.setOpaque(false);
        centerPanel.setOpaque(false);
        bottomPanel.setOpaque(false);

        // Add panels to main panel
        add(bgPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        // layeredPane.add(topPanel, new Integer(1));
        // layeredPane.add(centerPanel, new Integer(2));
        // layeredPane.add(bottomPanel, new Integer(3));
        // layeredPane.add(backHomeBtn, new Integer(4));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Previous")) {
            currentThemeImageIndex--;
            if (currentThemeImageIndex < 0) {
                currentThemeImageIndex = themeImages.size() - 1;
            }
            // System.out.println(getCurrentThemeName());

        } else if (e.getActionCommand().equals("Next")) {
            currentThemeImageIndex++;
            if (currentThemeImageIndex >= themeImages.size()) {
                currentThemeImageIndex = 0;
            }
            // System.out.println(getCurrentThemeName());
        } else if (e.getSource()==startBtn) {
            startGame = new Launcher();
            sprite = new PacManSprites();
            String path = getCurrentThemeName(); 
            sprite.setWallPath(path);
            sprite.setGroundPath(path);
            sprite.setPelletPath(path);
            startGame.setPacmanSprites(sprite);
            // send String of name file to sprite.setTheme(getCurrentThemeName());
            // sprite.getThemeSprite();
            // Sprite themeSprite = sprite.getThemeSprite();
            startGame.launch();
        } else if (e.getSource()==backHomeBtn) {
            new HomeUI().setVisible(true);
        }

        // Update the image label with the new image
        themeLabel.setIcon(themeImages.get(currentThemeImageIndex).getIcon());
    }
    
    //Return name of theme
    public String getCurrentThemeName() {
        return themeImages.get(currentThemeImageIndex).getName();
    }
    
}
