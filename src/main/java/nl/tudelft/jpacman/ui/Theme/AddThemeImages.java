package nl.tudelft.jpacman.ui.Theme;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class AddThemeImages {
    public static ArrayList<Theme> getImages() {
        ArrayList<Theme> themes = new ArrayList<>();
        themes.add(new Theme("Love", new ImageIcon("src/main/resources/sprite/love.png")));
        themes.add(new Theme("Xmas", new ImageIcon("src/main/resources/sprite/xmas.png")));
        themes.add(new Theme("Halloween", new ImageIcon("src/main/resources/sprite/halloween.png")));
        return themes;
    }
}
