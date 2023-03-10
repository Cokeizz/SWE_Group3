package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.Border;

public class SelectConfigureUI extends JFrame implements ActionListener {
    private Container c;
    private JLabel imgBg;
    private JPanel themePanel;
    private JPanel difficultyPanel;
    private JLabel imgTheme;
    private JLabel imgThemeXmas;
    private JLabel imgBgDifficultyBox;
    private Map theme;
    private int imgChacker = 3;
    private int currentImg = 1;
    private JButton startBtn;
    private JButton backHomeBtn;

    public SelectConfigureUI(){

        setTitle("Home");
        setBounds(300, 0, 800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        c = getContentPane();
        c.setLayout(null);

        //Add Image And Button
        ImageIcon logo = new ImageIcon("src/main/resources/sprite/bg.png");
        Image imagebg = logo.getImage();
        Image scaledImage = ((Image) imagebg).getScaledInstance(1920,1080,Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imgBg = new JLabel(scaledIcon);
        imgBg.setSize(1920,1080);
        imgBg.setLocation(-550,-240);

        ImageIcon imageIconStartBtn = new ImageIcon("src/main/resources/sprite/playbtn.png");
        Image startbtn = imageIconStartBtn.getImage();
        Image scaleImageStartBtn = ((Image) startbtn).getScaledInstance(200,100,Image.SCALE_SMOOTH);
        ImageIcon scaledImgStartBtn = new ImageIcon(scaleImageStartBtn);
        startBtn = new JButton(scaledImgStartBtn);
        startBtn.setBounds(300, 650, 200, 80);
        this.add(startBtn);

        ImageIcon imageIconBackBtn = new ImageIcon("src/main/resources/sprite/backbtn2.png");
        Image backbtn = imageIconBackBtn.getImage();
        Image scaleImageBackBtn = ((Image) backbtn).getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon scaledImageBackBtn = new ImageIcon(scaleImageBackBtn);
        backHomeBtn = new JButton(scaledImageBackBtn);
        backHomeBtn.setBounds(0, 0, 50, 50);
        this.add(backHomeBtn);

        ImageIcon tmpChooseBand = new ImageIcon("src/main/resources/sprite/chooseband.png");
        Image chooseBandLabel = tmpChooseBand.getImage();
        Image scaleChooseBandLabel = ((Image) chooseBandLabel).getScaledInstance(253,112,Image.SCALE_SMOOTH);
        ImageIcon scaledChooseBandLabel = new ImageIcon(scaleChooseBandLabel);
        JLabel choose = new JLabel(scaledChooseBandLabel);
        choose.setSize(1920,960);
        choose.setLocation(-565,-400);
        this.add(choose);

        ImageIcon tmpThemeLove = new ImageIcon("src/main/resources/sprite/love.png");
        Image themeLove = tmpThemeLove.getImage();
        Image scaleThemeLove = ((Image) themeLove).getScaledInstance(400,400,Image.SCALE_SMOOTH);
        ImageIcon scaledThemeLove = new ImageIcon(scaleThemeLove);

        ImageIcon tmpThemeXmas = new ImageIcon("src/main/resources/sprite/xmas.png");
        Image themeXmas = tmpThemeXmas.getImage();
        Image scaleThemeXmas = ((Image) themeXmas).getScaledInstance(400,400,Image.SCALE_SMOOTH);
        ImageIcon scaledThemeXmas = new ImageIcon(scaleThemeXmas);

        ImageIcon tmpThemeHalloween = new ImageIcon("src/main/resources/sprite/halloween.png");
        Image themeHalloween = tmpThemeHalloween.getImage();
        Image scaleThemeHalloween = ((Image) themeHalloween).getScaledInstance(400,400,Image.SCALE_SMOOTH);
        ImageIcon scaledThemeHalloween = new ImageIcon(scaleThemeHalloween);

        //imgBgDifficultyBox = new JLabel(scaledThemeBox);

        //Add Boarder in ThemePanel
        Border blackline = BorderFactory.createTitledBorder("Choose Theme");

        //Add Image To ThemePanel
        imgTheme = new JLabel(scaledThemeLove);

        //Create ThemePanel
        themePanel = new JPanel();
        themePanel.setBounds(200,150,400,480);
        themePanel.setBackground(Color.orange);
        themePanel.setBorder(blackline);

        //Add ThemePanel To Container and Add ImgTheme To Panel
        this.add(themePanel);
        themePanel.add(imgTheme);

        //Create Choose Theme Button
        JButton backBtn = new JButton("<-");
        themePanel.add(backBtn);
        JButton nextBtn = new JButton("->");
        themePanel.add(nextBtn);

        /*difficultyPanel = new JPanel();
        difficultyPanel.setBounds(400,150,400,450);
        difficultyPanel.setBackground(Color.orange);
        this.add(difficultyPanel);
        difficultyPanel.add(imgBgDifficultyBox);*/

        //Add Background Image
        this.add(imgBg);

        //Collect ImageIcon as Object in Hashmap
        HashMap<Integer, Object> theme = new HashMap<Integer, Object>();
        theme.put(1,scaledThemeLove);
        theme.put(2,scaledThemeXmas);
        theme.put(3,scaledThemeHalloween);

        //Action When Button is Clicked
        backHomeBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new HomeUI().setVisible(true);
                setVisible(false);

            }
        });

        startBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Launcher l1 = new Launcher();
                l1.launch();

                setVisible(false);

            }
        });
        
        nextBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                if(currentImg<imgChacker){
                    currentImg+=1;
                    imgTheme.setIcon((Icon) theme.get(currentImg));
                }else {
                    currentImg=1;
                    imgTheme.setIcon((Icon) theme.get(currentImg));
                }
                repaint();
            }
        });
        backBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(currentImg<=imgChacker&&currentImg>1){
                    currentImg-=1;
                    imgTheme.setIcon((Icon) theme.get(currentImg));
                }else {
                    currentImg=3;
                    imgTheme.setIcon((Icon) theme.get(currentImg));
                }
                repaint();
            }
        });




    }

    public void start(){
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
