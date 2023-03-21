package nl.tudelft.jpacman.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.ui.ScorePanel.ScoreFormatter;

/**
 * The default JPacMan UI frame. The PacManUI consists of the following
 * elements:
 *
 * <ul>
 * <li>A score panel at the top, displaying the score of the player(s).
 * <li>A board panel, displaying the current level, i.e. the board and all units
 * on it.
 * <li>A button panel, containing all buttons provided upon creation.
 * </ul>
 *
 * @author Jeroen Roosen 
 *
 */
public class PacManUI extends JFrame{

    /**
     * Default serialisation UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The desired frame rate interval for the graphics in milliseconds, 40
     * being 25 fps.
     */
    private static final int FRAME_INTERVAL = 40;

    /**
     * The panel displaying the player scores.
     */
    private final ScorePanel scorePanel;

    /**
     * The panel displaying the game.
     */
    private final BoardPanel boardPanel;

    private final TimePanel timePanel;
    private ScheduledExecutorService service;



    /**
     * Creates a new UI for a JPacman game.
     *
     * @param game
     *            The game to play.
     * @param buttons
     *            The map of caption-to-action entries that will appear as
     *            buttons on the interface.
     * @param keyMappings
     *            The map of keyCode-to-action entries that will be added as key
     *            listeners to the interface.
     * @param scoreFormatter
     *            The formatter used to display the current score.
     */
    public PacManUI(final Game game, final Map<ImageIcon, Action> buttons,
                    final Map<Integer, Action> keyMappings,
                    ScoreFormatter scoreFormatter, String difficulty) {
        super("JPacman");
        assert game != null;
        assert buttons != null;
        assert keyMappings != null;

       // buttons.put(new ImageIcon("src/main/resources/sprite/exitGameBtn.png"),this::exit);
        setBounds(300, 0, 800, 800);
        setResizable(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PacKeyListener keys = new PacKeyListener(keyMappings);
        addKeyListener(keys);

        JPanel buttonPanel = new ButtonPanel(buttons, this);


        scorePanel = new ScorePanel(game.getPlayers());

        if (scoreFormatter != null) {
            scorePanel.setScoreFormatter(scoreFormatter);
        }

        boardPanel = new BoardPanel(game);
        timePanel = new TimePanel(game);

        JLabel difLabel = new JLabel("                                Difficulty : "+difficulty);

        scorePanel.add(timePanel);
        scorePanel.add(difLabel);

        JButton exitBtn =new JButton(new ImageIcon("src/main/resources/sprite/exitGameBtn.png"));
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.stop();
                dispose();
                Launcher l1 = new Launcher();
                l1.launchConfigure();

            }
        });

        buttonPanel.add(exitBtn);

        Container contentPanel = getContentPane();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        contentPanel.add(scorePanel, BorderLayout.NORTH);
        contentPanel.add(boardPanel, BorderLayout.CENTER);
        //contentPanel.add(timePanel, BorderLayout.NORTH);
        //contentPanel.add(new JLabel("Difficulty : "+difficulty), BorderLayout.NORTH);

        pack();



    }

    /**
     * Starts the "engine", the thread that redraws the interface at set
     * intervals.
     */
    public void start() {
        setVisible(true);
        service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(this::nextFrame, 0, FRAME_INTERVAL, TimeUnit.MILLISECONDS);
    }
    public void exit(){
        dispose();
        Launcher l1 = new Launcher();
        l1.launchConfigure();
    }

    /**
     * Draws the next frame, i.e. refreshes the scores and game.
     */
    private void nextFrame() {
        boardPanel.repaint();
        scorePanel.refresh();
    }
}
