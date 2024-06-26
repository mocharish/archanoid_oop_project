// 328808159 Moshe Charish


import java.util.List;
import java.awt.Color;
import java.util.ArrayList;

/**
 * this class creates blocks.
 */
public class Block implements Collidable, Sprite, HitNotifier {

    private Rectangle rect;
    private Color color;

    private List<HitListener> hitListeners;

    /**
     * returns the rectangle that is the block.
     *
     * @return the rectangle that is the block
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * constructor of block.
     *
     * @param rect the rectangle that is the block
     */
    public Block(Rectangle rect) {
        this.rect = rect;
    }

    /**
     * constructs the block with rect and color.
     *
     * @param rect  the shape
     * @param color of rect
     */
    public Block(Rectangle rect, Color color) {
        this.color = color;
        this.rect = rect;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * constructs block using coordinates of upper left, width and height of rect and color.
     *
     * @param x      coordinate of upper left
     * @param y      coordinate of upper left
     * @param width  of rect
     * @param height of rect
     * @param color  of rect
     */
    public Block(double x, double y, double width, double height, Color color) {
        Point upper = new Point(x, y);
        this.rect = new Rectangle(upper, width, height);
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }
    /**
     * this function changes balls velocity according to hit with block.
     * @param hitter  hitter the ball that hits the block
     * @param collisionPoint  of ball with object
     * @param currentVelocity of ball
     * @return new velocity after collision
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        notifyHit(hitter);

        double newdx = currentVelocity.getDx();
        double newdy = currentVelocity.getDy();
        List<Line> linesarr = rect.lines();
        if (((linesarr.get(0).isonline(collisionPoint)) == 1) || ((linesarr.get(1).isonline(collisionPoint)) == 1)) {

            newdy = -1 * newdy;
        }
        if ((linesarr.get(2).isonline(collisionPoint)) == 1 || (linesarr.get(3).isonline(collisionPoint)) == 1) {
            newdx = newdx * -1;
        }
        return new Velocity(newdx, newdy);
    }

    /**
     * this function draws the blocks.
     *
     * @param drawSurface
     */
    public void drawOn(biuoop.DrawSurface drawSurface) {

        int x = (int) this.rect.getUpperLeft().getX();
        int y = (int) this.rect.getUpperLeft().getY();
        drawSurface.setColor(Color.black);
        drawSurface.drawRectangle(x, y, (int) this.rect.getWidth(), (int) this.rect.getHeight());
        drawSurface.setColor(this.color);
        drawSurface.fillRectangle(x, y, (int) this.rect.getWidth(), (int) this.rect.getHeight());
//        drawSurface.setColor(java.awt.Color.BLACK);
//        drawSurface.drawRectangle(x, y, (int)this.rect.getWidth(), (int)this.rect.getHeight());

    }

    /**
     * notifies how much time has passed.
     */
    public void timePassed() {

    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * adds block to game.
     *
     * @param game the game being played
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
        game.addCollidable(this);
    }

    /**
     * removes collidable and sprite from game.
     *
     * @param game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }


    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }


}
