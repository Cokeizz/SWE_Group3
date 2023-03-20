package nl.tudelft.jpacman.ui.Theme;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class AddThemeImages {


    private static ArrayList<Theme> themes;

    public static ArrayList<Theme> getImages() {

        themes = new ArrayList<>();
        themes.add(new Theme("origin", new ImageIcon("src/main/resources/sprite/origin.png")));
        themes.add(new Theme("love", new ImageIcon("src/main/resources/sprite/love.png")));
        themes.add(new Theme("xmas", new ImageIcon("src/main/resources/sprite/xmas.png")));
        themes.add(new Theme("halloween", new ImageIcon("src/main/resources/sprite/halloween.png")));
        return themes;
    }

    public void getTheme(){

    }
}
