package nl.tudelft.jpacman.ui.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MapPanel extends JPanel {
    private ArrayList<Map> maps;

    private int currentMapImageIndex;
    private JLabel mapImage;
    private JButton nextMapBtn;
    private JButton previousMapBtn;

    public MapPanel(ArrayList<Map> maps) {
        this.setMapImages(maps);

        currentMapImageIndex = 0;

//        mapImage = new JLabel(new ImageIcon("src/main/resources/sprite/map/map1.png"));

        mapImage.setIcon(maps.get(currentMapImageIndex).getMapIcon());
        mapImage.setHorizontalAlignment(SwingConstants.CENTER);
        mapImage.setBounds(60,200,240,240);

        nextMapBtn = new JButton(new ImageIcon("src/main/resources/sprite/nextMapBtn.png"));
        nextMapBtn.setBounds(315,300,40,40);
        nextMapBtn.setBorderPainted(false);

        previousMapBtn = new JButton(new ImageIcon("src/main/resources/sprite/previousMapBtn.png"));
        previousMapBtn.setBounds(0,300,40,40);
        previousMapBtn.setBorderPainted(false);

        getNextMapBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                currentMapImageIndex++;

                if (currentMapImageIndex >= getMapImages().size()) {
                    currentMapImageIndex = 0;
                }
                mapImage.setIcon(getMapImages().get(currentMapImageIndex).getMapIcon());
            }
        });

        getPreviousMapBtn().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                currentMapImageIndex--;

                if (currentMapImageIndex < 0) {
                    currentMapImageIndex = getMapImages().size() - 1;
                }
                mapImage.setIcon(getMapImages().get(currentMapImageIndex).getMapIcon());
            }
        });

        this.add(previousMapBtn);
        this.add(mapImage);
        this.add(nextMapBtn);
    }

    public ArrayList<Map> getMapImages() {
        return maps;
    }

    public void setMapImages(ArrayList<Map> maps) {
        this.maps = maps;
    }

    public JButton getNextMapBtn() {
        return nextMapBtn;
    }

    public JButton getPreviousMapBtn() {
        return previousMapBtn;
    }
}
