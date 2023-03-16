package nl.tudelft.jpacman.ui.Theme;

import javax.swing.ImageIcon;
import java.awt.*;

public class Theme {
    
    private String name;
    private ImageIcon icon;
    private Image img;
    private ImageIcon scaledImage;
    
    public Theme(String name, ImageIcon icon) {
        this.name = name;
        this.icon = icon;
    }
    
    public String getName() {
        return name;
    }
    
    public ImageIcon getIcon() {
        img = icon.getImage();
        scaledImage = new ImageIcon(img.getScaledInstance(400,400,Image.SCALE_SMOOTH));
        return scaledImage;
    }
    
}
