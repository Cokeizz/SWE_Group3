package nl.tudelft.jpacman.ui.Theme;

import javax.swing.*;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.ui.ConfigsUI;
import nl.tudelft.jpacman.ui.Map.Map;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ThemePanel extends JPanel implements ActionListener{

    private JLabel imgBg;

    private JPanel buttonPanel;

    private JLabel choose;
    private JButton backHomeBtn;
    private JButton startBtn;
    private String themeBG = "origin";

    private ArrayList<Theme> themeImages;

    private ArrayList<Map> mapImages;
    private int currentThemeImageIndex;

    private int currentMapImageIndex;
    private JLabel themeLabel;

    private Launcher startGame;
    private PacManSprites sprite;
    private JButton nextButton;
    private JButton previousButton;

    public ThemePanel(ArrayList<Theme> themes) {
        this.setThemeImages(themes);
        this.setLayout(new BorderLayout());

        this.setBackground(Color.orange);
        this.setOpaque(true);


        setCurrentThemeImageIndex(0);

        themeLabel = new JLabel();
        themeLabel.setIcon(themes.get(getCurrentThemeImageIndex()).getIcon());
        themeLabel.setHorizontalAlignment(SwingConstants.CENTER);


        // Create the previous and next buttons
        setPreviousButton(new JButton(new ImageIcon("src/main/resources/sprite/previousBtn.png")));
        getPreviousButton().addActionListener(this);
        setNextButton(new JButton(new ImageIcon("src/main/resources/sprite/nextBtn.png")));
        getNextButton().addActionListener(this);
        buttonPanel = new JPanel();
        buttonPanel.add(getPreviousButton());
        buttonPanel.add(getNextButton());
        buttonPanel.setOpaque(false);

        this.add(themeLabel,"Center");
        this.add(buttonPanel,"South");

        getNextButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setCurrentThemeImageIndex(getCurrentThemeImageIndex() + 1);

                if (getCurrentThemeImageIndex() >= getThemeImages().size()) {
                    setCurrentThemeImageIndex(0);
                }
                themeLabel.setIcon(getThemeImages().get(getCurrentThemeImageIndex()).getIcon());
            }
        });
        getPreviousButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setCurrentThemeImageIndex(getCurrentThemeImageIndex() - 1);

                if (getCurrentThemeImageIndex() < 0) {
                    setCurrentThemeImageIndex(getThemeImages().size() - 1);
                }
                themeLabel.setIcon(getThemeImages().get(getCurrentThemeImageIndex()).getIcon());
            }
        });

    }
    @Override
    public void actionPerformed(ActionEvent e) {


    }
    //Return name of theme
    public String getCurrentThemeName() {
        return getThemeImages().get(getCurrentThemeImageIndex()).getName();
    }
    public void startGame(String diff,int map){
        startGame = new Launcher();
        sprite = new PacManSprites();
        String path = getCurrentThemeName();
        sprite.setGhostPath(path);
        sprite.setPacmanPath(path);
        sprite.setWallPath(path);
        sprite.setGroundPath(path);
        sprite.setPelletPath(path);
        startGame.setPacmanSprites(sprite);
        startGame.setMap("/"+map+".txt");
        // send String of name file to sprite.setTheme(getCurrentThemeName());
        // sprite.getThemeSprite();
        // Sprite themeSprite = sprite.getThemeSprite();

        startGame.setLevelGhostFactory(diff);
        startGame.launchGame(diff);
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public void setNextButton(JButton nextButton) {
        this.nextButton = nextButton;
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public void setPreviousButton(JButton previousButton) {
        this.previousButton = previousButton;
    }

    public int getCurrentThemeImageIndex() {
        return currentThemeImageIndex;
    }

    public void setCurrentThemeImageIndex(int currentThemeImageIndex) {
        this.currentThemeImageIndex = currentThemeImageIndex;
    }

    public ArrayList<Theme> getThemeImages() {
        return themeImages;
    }

    public void setThemeImages(ArrayList<Theme> themeImages) {
        this.themeImages = themeImages;
    }

}
