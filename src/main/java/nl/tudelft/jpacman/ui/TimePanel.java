package nl.tudelft.jpacman.ui;

import java.awt.GridLayout;
import java.util.List;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nl.tudelft.jpacman.game.Game;

/**
 * A panel consisting of a label showing the remaining time of the game.
 */
public class TimePanel extends JPanel {

    /**
     * Default serialisation ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The label that displays the remaining time.
     */
    private final JLabel timeLabel;

    /**
     * Creates a new time panel that displays the remaining time of the game.
     *
     * @param game
     *            The game to display the remaining time of.
     */
    public TimePanel(Game game) {
        super();
        assert game != null;

        setLayout(new GridLayout(1, 1));

        timeLabel = new JLabel("", JLabel.CENTER);
        add(timeLabel);

        // Update the time label every second
        if (game.getRemainingTime() != 0) {
            new Timer(1000, e -> {
                int remainingTime = game.getRemainingTime();
                if (remainingTime >= 0){
                    timeLabel.setText(String.format("Time: %d seconds", remainingTime));
                }
            }).start();
        }
        timeLabel.setText("Time: Unlimited");
    }
}

