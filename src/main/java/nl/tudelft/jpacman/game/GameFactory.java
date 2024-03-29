package nl.tudelft.jpacman.game;

import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.points.PointCalculator;

/**
 * Factory that provides Game objects.
 *
 * @author Jeroen Roosen 
 */
public class GameFactory {

    /**
     * The factory providing the player objects.
     */
    private final PlayerFactory playerFactory;

    /**
     * Creates a new game factory.
     *
     * @param playerFactory
     *            The factory providing the player objects.
     */
    public GameFactory(PlayerFactory playerFactory) {
        this.playerFactory = playerFactory;
    }


    /**
     * Creates a game for a single level with one player.
     *
     * @param level
     *            The level to create a game for.
     * @param pointCalculator
     *             The way to calculate points upon collisions.
     * @return A new single player game.
     */
    public Game createSinglePlayerGame(Level level, PointCalculator pointCalculator) {
        return new SinglePlayerGame(playerFactory.createPacMan(), level, pointCalculator);
    }

    public Game createLevelDifficultyGame(Level level, PointCalculator pointCalculator, String difficulty) {
        int time = getTimeDifficulty(difficulty);
        return new SinglePlayerGame(playerFactory.createPacMan(), level, pointCalculator, time);
    }

    /**
     * Returns the player factory associated with this game factory.
     *
     * @return The player factory associated with this game factory.
     */

    public int getTimeDifficulty(String difficulty) {
        int time = 0;
        if (difficulty == "Hard") {
            time = 80;
        } else if (difficulty == "Easy" || difficulty == "Medium") {
            return time;
        } else if (difficulty == "Super Hard") {
            time = 50;
        }
        return time;
    }
    protected PlayerFactory getPlayerFactory() {
        return playerFactory;
    }
}
