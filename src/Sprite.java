// 328808159 Moshe Charish


import biuoop.DrawSurface;

/**
 * this interface represents a drawable object.
 */
public interface Sprite {

    /**
     * draws object on the screen.
     * @param d
     */
    void drawOn(DrawSurface d);


    /**
     * notifies sprite of time change.
     */
    void timePassed();
}
