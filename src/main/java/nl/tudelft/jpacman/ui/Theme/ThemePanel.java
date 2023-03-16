package nl.tudelft.jpacman.ui.Theme;

import javax.swing.*;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.sprite.Sprite;
import nl.tudelft.jpacman.ui.HomeUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
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

        this.setLayout(new BorderLayout());

        this.setBackground(Color.orange);





        currentThemeImageIndex = 0;

        themeLabel = new JLabel();
        themeLabel.setIcon(themes.get(currentThemeImageIndex).getIcon());
        themeLabel.setHorizontalAlignment(SwingConstants.CENTER);


        // Create the previous and next buttons
        JButton previousButton = new JButton("Previous");
        previousButton.addActionListener(this);
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        buttonPanel = new JPanel();
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        buttonPanel.setOpaque(false);

        this.add(themeLabel,"Center");
        this.add(buttonPanel,"South");


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
        }
        // Update the image label with the new image
        themeLabel.setIcon(themeImages.get(currentThemeImageIndex).getIcon());
    }
    //Return name of theme
    public String getCurrentThemeName() {
        return themeImages.get(currentThemeImageIndex).getName();
    }
    public void startGame(){
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
    }

}
