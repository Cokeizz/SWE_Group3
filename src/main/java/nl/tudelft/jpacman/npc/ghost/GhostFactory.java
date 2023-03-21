package nl.tudelft.jpacman.npc.ghost;

import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.sprite.PacManSprites;

/**
 * Factory that creates ghosts.
 *
 * @author Jeroen Roosen 
 */
public class GhostFactory {

    /**
     * The sprite store containing the ghost sprites.
     */
    private String level;
    private Integer MoveSpeed;
    private final PacManSprites sprites;

    public void setGhostMoveSpeed(String level){
        if(level.equals("Easy")){
            this.MoveSpeed = 400;
        } else if (level.equals("Medium")) {
            this.MoveSpeed = 325;
        }
        else if (level.equals("Hard")) {
            this.MoveSpeed = 250;
        }
        else if (level.equals("Super Hard")) {
            this.MoveSpeed = 175;
        }
        else{
            this.MoveSpeed = 250;
        }
    }

    /**
     * Creates a new ghost factory.
     *
     * @param spriteStore The sprite provider.
     */
    public GhostFactory(PacManSprites spriteStore) {
        this.sprites = spriteStore;
    }

    /**
     * Creates a new Blinky / Shadow, the red Ghost.
     *
     * @see Blinky
     * @return A new Blinky.
     */
    public Ghost createBlinky() {
        Blinky ghost_bk = new Blinky(sprites.getGhostSprite(GhostColor.RED),this.MoveSpeed);
        return ghost_bk;
    }

    /**
     * Creates a new Pinky / Speedy, the pink Ghost.
     *
     * @see Pinky
     * @return A new Pinky.
     */
    public Ghost createPinky() {
        return new Pinky(sprites.getGhostSprite(GhostColor.PINK),this.MoveSpeed);
    }

    /**
     * Creates a new Inky / Bashful, the cyan Ghost.
     *
     * @see Inky
     * @return A new Inky.
     */
    public Ghost createInky() {
//        Inky ghost_ik = new Inky(sprites.getGhostSprite(GhostColor.ORANGE));
//        ghost_ik.setMoveInterval(getMoveSpeed());
//        return ghost_ik;
        return new Inky(sprites.getGhostSprite(GhostColor.ORANGE),this.MoveSpeed);
    }

    /**
     * Creates a new Clyde / Pokey, the orange Ghost.
     *
     * @see Clyde
     * @return A new Clyde.
     */
    public Ghost createClyde() {
        return new Clyde(sprites.getGhostSprite(GhostColor.CYAN),this.MoveSpeed);
    }
}
