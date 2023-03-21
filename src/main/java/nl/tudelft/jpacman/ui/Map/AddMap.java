package nl.tudelft.jpacman.ui.Map;

import javax.swing.*;
import java.util.ArrayList;

public class AddMap {
    private static ArrayList<Map> maps;

    public static ArrayList<Map> getMaps() {
        maps = new ArrayList<>();
        maps.add(new Map("map1", new ImageIcon("src/main/resources/sprite/map/map1.png")));
        maps.add(new Map("map2", new ImageIcon("src/main/resources/sprite/map/map2.jpg")));
        maps.add(new Map("map3", new ImageIcon("src/main/resources/sprite/map/map3.png")));
        return maps;
    }
}
