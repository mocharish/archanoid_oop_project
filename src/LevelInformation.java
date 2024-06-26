// 328808159 Moshe Charish


import java.util.List;

/**
 * this interface holds information on all the levels.
 */
public interface LevelInformation {
    /**
     * number of balls.
     *
     * @return balls num
     */
    int numberOfBalls();
    // Note that initialBallVelocities().size() == numberOfBalls()

    /**
     * The initial velocity of each ball.
     *
     * @return velocity
     */
    List<Velocity> initialBallVelocities();

    /**
     * the paddle speed.
     * @return speed
     */
    int paddleSpeed();

    /**
     * the paddle width.
     *
     * @return width
     */
    int paddleWidth();
    // the level name will be displayed at the top of the screen.

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return name
     */
    String levelName();
    // Returns a sprite with the background of the level

    /**
     * Returns a sprite with the background of the level.
     *
     * @return background
     */
    Sprite getBackground();
    // The Blocks that make up this level, each block contains
    // its size, color and location.

    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return list of blocks
     */
    List<Block> blocks();
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();

    /**
     * blocks to remove.
     *
     * @return num of blocks
     */
    int numberOfBlocksToRemove();
}

