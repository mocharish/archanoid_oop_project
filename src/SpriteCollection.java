// 328808159 Moshe Charish

import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;

/**
 * collection of sprites.
 */
public class SpriteCollection {

    private java.util.List<Sprite> spriteList;

    /**
     * gets a new sprite collection.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<Sprite>();
    }

    /**
     * creates list of sprites.
     * @return list
     */
    public List<Sprite> getSpriteList() {
        return this.spriteList;
    }

    /**
     * adds sprite to collection.
     *
     * @param s
     */
    public void addSprite(Sprite s) {
        this.spriteList.add(s);
    }

    /**
     * notifies sprites about time change.
     */
    public void notifyAllTimePassed() {
//
        List<Sprite> lst = new ArrayList<Sprite>(this.spriteList);
        for (Sprite sp : lst) {

            sp.timePassed();
        }
    }

    /**
     * draws sprites on surface.
     *
     * @param d
     */
    public void drawAllOn(DrawSurface d) {

        for (Sprite spr : spriteList) {
            spr.drawOn(d);
        }
    }

    /**
     * removes sprite.
     * @param s
     */
    public void removeS(Sprite s) {
        this.spriteList.remove(s);
    }

}
