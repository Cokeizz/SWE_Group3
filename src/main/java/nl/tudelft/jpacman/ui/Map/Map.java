package nl.tudelft.jpacman.ui.Map;

import javax.swing.*;
import java.awt.*;

public class Map {

    private String map;

    private ImageIcon mapImage;

    public Map(String map, ImageIcon mapImage) {
        this.map = map;
        this.mapImage = mapImage;
    }

    public Map() {}

    public String getMap() {
        return this.map;
    }

    public ImageIcon getMapIcon() {
        Image img = mapImage.getImage();
        ImageIcon scaledImage = new ImageIcon(img.getScaledInstance(360,360, Image.SCALE_SMOOTH));
        return scaledImage;
    }
}
