package nl.tudelft.jpacman.ui.Theme;

import javax.swing.ImageIcon;

public class Theme {
    
    private String name;
    private ImageIcon icon;
    
    public Theme(String name, ImageIcon icon) {
        this.name = name;
        this.icon = icon;
    }
    
    public String getName() {
        return name;
    }
    
    public ImageIcon getIcon() {
        return icon;
    }
    
}
