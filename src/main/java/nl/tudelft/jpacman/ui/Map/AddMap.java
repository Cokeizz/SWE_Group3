package nl.tudelft.jpacman.ui.Map;

import javax.swing.*;
import java.lang.reflect.Array;
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

    public static ArrayList<Map> getAllMapsTxt() {
        maps = new ArrayList<>();
        maps.add(new Map("map1", "src/main/resources/0.txt"));
        maps.add(new Map("map2", "src/main/resources/1.txt"));
        maps.add(new Map("map3", "src/main/resources/2.txt"));
        maps.add(new Map("map4", "src/main/resources/3.txt"));
        maps.add(new Map("map5", "src/main/resources/4.txt"));
        return maps;
    }
}
