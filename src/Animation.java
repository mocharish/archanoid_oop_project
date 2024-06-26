// 328808159 Moshe Charish

import biuoop.DrawSurface;

/**
 * Creates a animation
 */
public interface Animation {
    /**
     * runs a frame
     * @param d drawface
     */
    void doOneFrame(DrawSurface d);

    /**
     * checks if to stop
     * @return true or false
     */
    boolean shouldStop();

}
