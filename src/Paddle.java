// 328808159 Moshe Charish

import java.awt.Color;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

/**
 * this class creates paddle.
 */
public class Paddle implements Collidable, Sprite {

    private KeyboardSensor keyboardSensor;
    private Rectangle rect;
    private Color color;
    private GameEnvironment gameenvironment;
    private GUI gui;
    private static int width = 800;
    private static int border = 50;

    /**
     * constructs paddle with rect, border, color and gui.
     * @param rectangle
     * @param border
     * @param color
     * @param gui
     */
    public Paddle(Rectangle rectangle, int border, Color color, GUI gui) {
        this.color = color;
        this.rect = rectangle;
        this.keyboardSensor = gui.getKeyboardSensor();
    }

    /**
     * constructs paddle with rect, border, color, keyboard sensor and gui.
     * @param rectangle
     * @param border
     * @param color
     * @param gui
     * @param keyboardSensor
     */
    public Paddle(Rectangle rectangle, int border, Color color, GUI gui, KeyboardSensor keyboardSensor) {
        this.color = color;
        this.rect = rectangle;
        this.keyboardSensor = keyboardSensor;

    }

    /**
     * sets game environment.
     * @param gameenvironment
     */
    public void setGameenvironment(GameEnvironment gameenvironment) {
        this.gameenvironment = gameenvironment;
    }

    /**
     * makes paddle move to the left.
     */
    public void moveLeft() {
        if (keyboardSensor.isPressed(KeyboardSensor.LEFT_KEY) && this.rect.getUpperLeft().getX() > this.border + 10) {
            Point next = new Point(this.rect.getUpperLeft().getX() - 20, this.rect.getUpperLeft().getY());
            this.rect = new Rectangle(next, this.rect.getWidth(), this.rect.getHeight());
        }
    }
    /**
     * makes paddle move to the right.
     */
    public void moveRight() {
        if (keyboardSensor.isPressed(KeyboardSensor.RIGHT_KEY)
                && this.rect.getUpperLeft().getX() + rect.getWidth() < width - this.border - 10) {
            Point next2 = new Point(this.rect.getUpperLeft().getX() + 20, this.rect.getUpperLeft().getY());
            this.rect = new Rectangle(next2, this.rect.getWidth(), this.rect.getHeight());
        }
    }

    /**
     * notifies paddle that time has passed.
     */
    public void timePassed() {
        this.moveLeft();
        this.moveRight();
    }

    /**
     * draws paddle on surface.
     * @param d
     */
    public void drawOn(DrawSurface d) {
        int recwidth = (int) this.rect.getWidth();
        int recheight = (int) this.rect.getHeight();
        int x = (int) this.rect.getUpperLeft().getX();
        int y = (int) this.rect.getUpperLeft().getY();
        d.setColor(color);
        d.fillRectangle(x, y, recwidth, recheight);
    }

    /**
     * returns the object of collision.
     * @return rect
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * changes velocity of ball according to the hit point on the paddle.
     * @param hitter the ball
     * @param collisionPoint  of ball with object
     * @param currentVelocity of ball
     * @return new velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        double velocityx = currentVelocity.getDx();
        double velocityy = currentVelocity.getDy();
        //  double speed =  Math.sqrt((velocityx * velocityx) + (velocityy * velocityy));
        Velocity nextvelocity = currentVelocity;
        java.util.List<Line> listoflines = rect.lines();
        if (listoflines.get(0).isonline(collisionPoint) == 1) {
            int areaonpaddle = areaofhit(collisionPoint);
            if (areaonpaddle == 3) {
                velocityy = velocityy * -1;
                nextvelocity = new Velocity(velocityx, velocityy);
            } else if (areaonpaddle == -1) {
                nextvelocity = null;
            } else if (areaonpaddle == 5) {
                double ang = 150;
                nextvelocity = Velocity.fromAngleAndSpeed(ang, Math.sqrt((velocityx * velocityx)
                        + (velocityy * velocityy)));
            } else if (areaonpaddle == 4) {
                double ang = 130;
                nextvelocity = Velocity.fromAngleAndSpeed(ang, Math.sqrt((velocityx * velocityx)
                        + (velocityy * velocityy)));
            } else if (areaonpaddle == 2) {
                double ang = 50;
                nextvelocity = Velocity.fromAngleAndSpeed(ang, Math.sqrt((velocityx * velocityx)
                        + (velocityy * velocityy)));
            } else if (areaonpaddle == 1) {
                double ang = 70;
                nextvelocity = Velocity.fromAngleAndSpeed(ang, Math.sqrt((velocityx * velocityx)
                        + (velocityy * velocityy)));
            } else {
                double ang = 0;
                nextvelocity = Velocity.fromAngleAndSpeed(ang, Math.sqrt((velocityx * velocityx)
                        + (velocityy * velocityy)));
            }
            //  return nextvelocity;
        }
        if (listoflines.get(2).isonline(collisionPoint) == 1 || listoflines.get(3).isonline(collisionPoint) == 1) {
            nextvelocity = new Velocity(-velocityx, velocityy);
        }
        return nextvelocity;
    }

    /**
     * adds paddle to game.
     * @param game
     */
    public void addToGame(GameLevel game) {
        game.addCollidable(this);
        game.addSprite(this);
    }

    /**
     * calculates where on the paddle the ball hit.
     * @param p
     * @return area of collision
     */
    public int areaofhit(Point p) {
        double xpoint = p.getX();
        double width = this.rect.getWidth() / 5;
        for (int i = 4; i > -1; i--) {
            double areaonpaddle = this.rect.getUpperLeft().getX() + (width * i);
            if (xpoint > areaonpaddle) {
                return i + 1;
            }
        }
        return -1;
    }

}
