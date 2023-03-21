package nl.tudelft.jpacman.board;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.GameFactory;
import nl.tudelft.jpacman.game.SinglePlayerGame;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.ui.ConfigsUI;
import nl.tudelft.jpacman.ui.PacManUI;
import nl.tudelft.jpacman.ui.PacManUiBuilder;
import nl.tudelft.jpacman.ui.Theme.AddThemeImages;
import nl.tudelft.jpacman.ui.Theme.ThemePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LevelTest {

    private Launcher launcher;

    private DefaultPointCalculator point;

    private ThemePanel themePanel;

    private Game game;
    private Level level;
    private GameFactory gameFactory;

    private GhostFactory ghostFactory;
    private ConfigsUI configs;

    private PacManUI pacManUI;

    private PacManUiBuilder pacManUiBuilder;
    private static class TestLauncher extends Launcher {
        public TestLauncher() {
            super();
        }

        public GameFactory testGetGameFactory() {
            GameFactory gameFactory = getGameFactory();
            return gameFactory;
        }

        public GhostFactory testGetGhostFactory() {
            GhostFactory ghostFactory = getGhostFactory();
            return ghostFactory;
        }
    }

    @BeforeEach
    public void setUp() {
        launcher = new Launcher();
        themePanel = new ThemePanel(AddThemeImages.getImages());
        TestLauncher testLauncher = new TestLauncher();
        gameFactory = testLauncher.testGetGameFactory();
//        ghostFactory = testLauncher.testGetGhostFactory();
        point = new DefaultPointCalculator();
        configs = new ConfigsUI();
        pacManUiBuilder = new PacManUiBuilder();
    }

    @Test
    public void testLevelEasy() {
        configs.getEasyDifBtn().doClick();
        assertEquals("Easy", configs.getCurrentDifficulty());
    }

    @Test
    public void testLevelMedium() {
        configs.getMediumDifBtn().doClick();
        assertEquals("Medium", configs.getCurrentDifficulty());
    }

    @Test
    public void testLevelHard() {
        configs.getHardDifBtn().doClick();
        assertEquals("Hard", configs.getCurrentDifficulty());
    }

    @Test
    public void testLevelSuperHard() {
        configs.getSuperHardDifBtn().doClick();
        assertEquals("Super Hard", configs.getCurrentDifficulty());
    }

    @Test
    public void testTimeLevelHard() {
        String difficulty = "Hard";
        themePanel.startGame(difficulty, 1);
//        launcher.launchGame(difficulty);
        int time = gameFactory.getTimeDifficulty(difficulty);
        assertEquals(80, time);
    }

    @Test
    public void testTimeLevelSuperHard() {
        String difficulty = "Super Hard";
        themePanel.startGame(difficulty, 1);
        int time = gameFactory.getTimeDifficulty(difficulty);
        assertEquals(50, time);
    }

    @Test
    public void testTimeLevelEasyAndMedium() {
        String difficulty1 = "Easy";
        themePanel.startGame(difficulty1, 1);
        int time = gameFactory.getTimeDifficulty(difficulty1);
        assertEquals(0, time);

        String difficulty2 = "Medium";
        themePanel.startGame(difficulty2,1);
        int time1 = gameFactory.getTimeDifficulty(difficulty2);
        assertEquals(0, time1);
    }

}
