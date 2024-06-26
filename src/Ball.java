// 328808159 Moshe Charish

import java.awt.Color;

import biuoop.DrawSurface;

//import biuoop.DrawSurface;

/**
 * In this class we create a ball.
 */
public class Ball implements Sprite {

    private int size;
    private Point p;
    private Color color;
    private Velocity velocity;
    private int width;
    private int height;
    private GameEnvironment gameenvironment;

    /**
     * constructor.
     */
    public Ball() {
        this.p = p;
        this.color = color;
        this.size = size;
        this.velocity = new Velocity();
        this.width = width;
        this.height = height;
        this.gameenvironment = new GameEnvironment();
    }

    /**
     * construct ball from point, color and radius size.
     *
     * @param x     coordinate
     * @param y     coordinate
     * @param color of ball
     * @param size  of rad
     */
    public Ball(double x, double y, Color color, int size) {
        this.p = new Point(x, y);
        this.color = color;
        this.size = size;
        this.velocity = new Velocity();
        //  this.gameenvironment = new GameEnvironment();
    }

    /**
     * constuctor method.
     *
     * @param x     point of center of the ball
     * @param y     x point of center of the ball
     * @param color x of the ball
     * @param size  of balls radius
     * @param game  the game environment
     */
    public Ball(double x, double y, Color color, int size, GameEnvironment game) {
        this.p = new Point(x, y);
        this.color = color;
        this.size = size;
        this.velocity = new Velocity();
        this.gameenvironment = game;
    }

    /**
     * construct ball from point, color, radius size, width and height of surface.
     *
     * @param x      coordinate
     * @param y      coordinate
     * @param color  of ball
     * @param size   of rad
     * @param height of surface
     * @param width  of surface
     */
    public Ball(double x, double y, Color color, int size, int height, int width) {
        this.p = new Point(x, y);
        this.color = color;
        this.size = size;
        this.velocity = new Velocity();
        this.height = height;
        this.width = width;
        //  this.gameenvironment = new GameEnvironment();
    }

    /**
     * gets the rounded value of the x coordinate of the center of the ball.
     *
     * @return the rounded x coordinate
     */
    public int getX() {
        return Math.round((int) (this.p.getX()));
    }

    /**
     * gets the rounded value of the y coordinate of the center of the ball.
     *
     * @return y value of the coordinate
     */
    public int getY() {
        return Math.round((int) (this.p.getY()));
    }

//public void setP(double x, double y) {
//        this.p = new Point(x,y);
//}

    /**
     * this function returns the center point of ball.
     *
     * @return center point
     */
    public Point getP() {
        return this.p;
    }

    /**
     * gets the size of the raius.
     *
     * @return radius
     */
    public int getSize() {
        return this.size;
    }

    /**
     * gets color of the ball.
     *
     * @return color
     */


    public java.awt.Color getColor() {
        return this.color;
    }


    /**
     * draws the ball on the surface.
     *
     * @param surface with ball
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.size);

    }

    /**
     * this function gives the ball a time limit.
     */
    public void timePassed() {
        moveOneStep();
        this.gameenvironment.stuckinblock(this);
    }


    /**
     * adds velocity to the ball.
     *
     * @param v velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * adds velocity to ball through the x and y value change.
     *
     * @param dx
     * @param dy
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * returns the velocity of the ball.
     *
     * @return velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * this function sets the balls center point.
     *
     * @param x coordinate of ball center
     * @param y coordinate of ball center
     */
    public void setCenter(double x, double y) {
        this.p = new Point(x, y);

    }

    /**
     * sets the game environment.
     *
     * @param gameenvironment of game
     */
    public void setGameEnvironment(GameEnvironment gameenvironment) {
        this.gameenvironment = gameenvironment;
    }


    /**
     * returns the game environment of ball.
     *
     * @return game environment of ball
     */
    public GameEnvironment getgameEnvironment() {
        return this.gameenvironment;
    }

    /**
     * this function makes sure the ball will not leave its borders.
     *
     * @param width  of surface
     * @param height of surface
     * @param x      starting point of width of surface
     * @param y      starting point of height of surface
     */
    public void stayin(int width, int height, int x, int y) {
        double futurespotx = this.p.getX() + this.velocity.getDx();
        double futurespoty = this.p.getY() + this.velocity.getDy();
        if (futurespotx + this.size > width || futurespotx - this.size < x) {
            this.setVelocity(-this.velocity.getDx(), this.velocity.getDy());
        }
        if (futurespoty + this.size > height || futurespoty - this.size < y) {
            this.setVelocity(this.velocity.getDx(), -this.velocity.getDy());
        }
    }

    /**
     * this function helps move the ball along on the screen.
     * @return new line where ball will be moving.
     */
    public Line movingtonextspot() {
        Point beginningofline = new Point(
                Math.floor(this.p.getX()), Math.floor(this.p.getY()));
        Point endofline = new Point(Math.floor(this.p.getX() + this.velocity.getDx()),
                Math.floor(this.p.getY() + this.velocity.getDy()));
        Line next = new Line(beginningofline, endofline);
        return next;
    }

    /**
     * this function moves the ball according to it's velocity.
     */
    public void moveOneStep() {
        if (
                this.gameenvironment.getClosestCollision(this.movingtonextspot()) != null) {
            this.setVelocity(this.gameenvironment.getClosestCollision(
                    this.movingtonextspot()).collisionObject().hit(this,
                    this.gameenvironment.getClosestCollision(
                            this.movingtonextspot()).collisionPoint(),
                    this.getVelocity()));
        }
        this.p = this.getVelocity().applyToPoint(this.p);
    }

    /**
     * this function adds the ball to the sprites list.
     * @param game the game being played
     */
    public void addtogame(GameLevel game) {
        this.gameenvironment = new GameEnvironment();
        game.addSprite(this);
    }

    /**
     * removes sprite from the game.
     * @param game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}
