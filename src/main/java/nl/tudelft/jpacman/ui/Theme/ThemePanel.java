package nl.tudelft.jpacman.ui.Theme;

import javax.swing.*;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.ui.ConfigsUI;

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
    private String themeBG = "origin";

    private ArrayList<Theme> themeImages;
    private int currentThemeImageIndex;
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
        setPreviousButton(new JButton("Previous"));
        getPreviousButton().addActionListener(this);
        setNextButton(new JButton("Next"));
        getNextButton().addActionListener(this);
        buttonPanel = new JPanel();
        buttonPanel.add(getPreviousButton());
        buttonPanel.add(getNextButton());
        buttonPanel.setOpaque(false);

        this.add(themeLabel,"Center");
        this.add(buttonPanel,"South");


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Previous")) {
            setCurrentThemeImageIndex(getCurrentThemeImageIndex() - 1);

            if (getCurrentThemeImageIndex() < 0) {
                setCurrentThemeImageIndex(getThemeImages().size() - 1);

            }
            // System.out.println(getCurrentThemeName());

        } else if (e.getActionCommand().equals("Next")) {
            setCurrentThemeImageIndex(getCurrentThemeImageIndex() + 1);

            if (getCurrentThemeImageIndex() >= getThemeImages().size()) {
                setCurrentThemeImageIndex(0);
            }
        }
        // Update the image label with the new image


        themeLabel.setIcon(getThemeImages().get(getCurrentThemeImageIndex()).getIcon());

        //System.out.println(themeImages.get(currentThemeImageIndex).getName());
    }
    //Return name of theme
    public String getCurrentThemeName() {
        return getThemeImages().get(getCurrentThemeImageIndex()).getName();
    }
    public void startGame(){
        startGame = new Launcher();
        sprite = new PacManSprites();
        String path = getCurrentThemeName();
        sprite.setGhostPath(path);
        sprite.setPacmanPath(path);
        sprite.setWallPath(path);
        sprite.setGroundPath(path);
        sprite.setPelletPath(path);
        startGame.setPacmanSprites(sprite);
        startGame.setMap("/0.txt");
        // send String of name file to sprite.setTheme(getCurrentThemeName());
        // sprite.getThemeSprite();
        // Sprite themeSprite = sprite.getThemeSprite();
        startGame.launch();
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
