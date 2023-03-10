package nl.tudelft.jpacman.sprite;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import nl.tudelft.jpacman.PacmanConfigurationException;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.npc.ghost.GhostColor;

/**
 * Sprite Store containing the classic Pac-Man sprites.
 *
 * @author Jeroen Roosen 
 */
public class PacManSprites extends SpriteStore {

    private String themeSprite;

    /**
     * The sprite files are vertically stacked series for each direction, this
     * array denotes the order.
     */
    private static final Direction[] DIRECTIONS = {
        Direction.NORTH,
        Direction.EAST,
        Direction.SOUTH,
        Direction.WEST
    };
    
    /**
     * The image size in pixels.
     */
    private static final int SPRITE_SIZE = 16;

    /**
     * The amount of frames in the pacman animation.
     */
    private static final int PACMAN_ANIMATION_FRAMES = 4;

    /**
     * The amount of frames in the pacman dying animation.
     */
    private static final int PACMAN_DEATH_FRAMES = 11;

    /**
     * The amount of frames in the ghost animation.
     */
    private static final int GHOST_ANIMATION_FRAMES = 2;

    /**
     * The delay between frames.
     */
    private static final int ANIMATION_DELAY = 200;

    private String WallPath;
    private String GroundPath;
    private String PelletPath;

    /**
     * @return A map of animated Pac-Man sprites for all directions.
     */
    public Map<Direction, Sprite> getPacmanSprites() {
        return directionSprite("/sprite/pacman.png", PACMAN_ANIMATION_FRAMES);
    }

    /**
     * @return The animation of a dying Pac-Man.
     */
    public AnimatedSprite getPacManDeathAnimation() {
        String resource = "/sprite/dead.png";

        Sprite baseImage = loadSprite(resource);
        AnimatedSprite animation = createAnimatedSprite(baseImage, PACMAN_DEATH_FRAMES,
            ANIMATION_DELAY, false);
        animation.setAnimating(false);

        return animation;
    }

    /**
     * Returns a new map with animations for all directions.
     *
     * @param resource
     *            The resource name of the sprite.
     * @param frames
     *            The number of frames in this sprite.
     * @return The animated sprite facing the given direction.
     */
    private Map<Direction, Sprite> directionSprite(String resource, int frames) {
        Map<Direction, Sprite> sprite = new HashMap<>();

        Sprite baseImage = loadSprite(resource);
        for (int i = 0; i < DIRECTIONS.length; i++) {
            Sprite directionSprite = baseImage.split(0, i * SPRITE_SIZE, frames
                * SPRITE_SIZE, SPRITE_SIZE);
            AnimatedSprite animation = createAnimatedSprite(directionSprite,
                frames, ANIMATION_DELAY, true);
            animation.setAnimating(true);
            sprite.put(DIRECTIONS[i], animation);
        }

        return sprite;
    }

    /**
     * Returns a map of animated ghost sprites for all directions.
     *
     * @param color
     *            The colour of the ghost.
     * @return The Sprite for the ghost.
     */
    public Map<Direction, Sprite> getGhostSprite(GhostColor color) {
        assert color != null;

        String resource = "/sprite/ghost_" + color.name().toLowerCase()
            + ".png";
        return directionSprite(resource, GHOST_ANIMATION_FRAMES);
    }

    /**
     * @return The sprite for the wall.
     */
    public void setWallPath(String path){
        this.WallPath = "/sprite/"+path;
    }
    public String getWallPath(){
       return this.WallPath;
    }
    public Sprite getWallSprite() {

        return loadSprite(getWallPath());


    }

    /**
     * @return The sprite for the ground.
     */
    public void setGroundPath(String path){
        this.GroundPath = "/sprite/"+path;
    }
    public String getGroundPath(){
        return this.GroundPath;
    }
    public Sprite getGroundSprite() {
        return loadSprite(getGroundPath());
    }


    /**
     * @return The sprite for the
     */
    public void setPelletPath(String path){
        this.PelletPath = "/sprite/"+path;
    }
    public String getPelletPath(){
        return this.PelletPath;
    }
    public Sprite getPelletSprite() {

        return loadSprite(getPelletPath());

    }

    /**
     * Overloads the default sprite loading, ignoring the exception. This class
     * assumes all sprites are provided, hence the exception will be thrown as a
     * {@link RuntimeException}.
     *
     * {@inheritDoc}
     */
    @Override
    public Sprite loadSprite(String resource) {
        try {
            return super.loadSprite(resource);
        } catch (IOException e) {
            throw new PacmanConfigurationException("Unable to load sprite: " + resource, e);
        }
    }

    public void setTheme(String theme) {
        this.themeSprite = theme;
    }
    
    public Sprite getThemeSprite() {
        if (this.themeSprite != null) {
            return loadSprite("/sprite/theme/" + this.themeSprite + "/wall.png");
        } else {
            // default sprite if no theme is set
            return getWallSprite();
        }
    }
}
