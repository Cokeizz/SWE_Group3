package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.ui.ConfigsUI;
import nl.tudelft.jpacman.ui.Theme.AddThemeImages;
import nl.tudelft.jpacman.ui.Theme.ThemePanel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * A very simple (and not particularly useful)
 * test class to have a starting point where to put tests.
 *
 * @author Arie van Deursen
 */
public class ThemeTest {
    /**
     * Do we get the correct delta when moving north?
     */

    ThemePanel themePanel1 = new ThemePanel(AddThemeImages.getImages());
    ThemePanel themePanel2 = new ThemePanel(AddThemeImages.getImages());

    ConfigsUI configsUI = new ConfigsUI();

    @Test
    void testNextTheme() {
        System.out.println(themePanel1.getCurrentThemeName());
        assertEquals("origin",themePanel1.getCurrentThemeName());

        themePanel1.getNextButton().doClick();

        System.out.println(themePanel1.getCurrentThemeName());
        assertEquals("love",themePanel1.getCurrentThemeName());

        themePanel1.getNextButton().doClick();

        System.out.println(themePanel1.getCurrentThemeName());
        assertEquals("xmas",themePanel1.getCurrentThemeName());

        themePanel1.getNextButton().doClick();

        System.out.println(themePanel1.getCurrentThemeName());
        assertEquals("halloween",themePanel1.getCurrentThemeName());

        themePanel1.getNextButton().doClick();

        System.out.println(themePanel1.getCurrentThemeName());
        assertEquals("origin",themePanel1.getCurrentThemeName());
    }
    @Test
    void testPreviousTheme() {
        System.out.println(themePanel2.getCurrentThemeName());
        assertEquals("origin",themePanel2.getCurrentThemeName());

        themePanel2.getPreviousButton().doClick();

        System.out.println(themePanel2.getCurrentThemeName());
        assertEquals("halloween",themePanel2.getCurrentThemeName());

        themePanel2.getPreviousButton().doClick();

        System.out.println(themePanel2.getCurrentThemeName());
        assertEquals("xmas",themePanel2.getCurrentThemeName());

        themePanel2.getPreviousButton().doClick();

        System.out.println(themePanel2.getCurrentThemeName());
        assertEquals("love",themePanel2.getCurrentThemeName());

        themePanel2.getPreviousButton().doClick();

        System.out.println(themePanel2.getCurrentThemeName());
        assertEquals("origin",themePanel2.getCurrentThemeName());

        themePanel2.getPreviousButton().doClick();
    }
    @Test
    void testLaunchTheme() {
        configsUI.start();
        configsUI.getStartBtn().doClick();
        //ConfigUI Suppose to be closed!
        assertEquals(false,configsUI.isShowing());

    }


}
