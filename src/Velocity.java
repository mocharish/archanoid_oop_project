// 328808159 Moshe Charish

/**
 * This class gets the velocity of the ball.
 */
public class Velocity {

    private double dx;
    private double dy;

    /**
     * constructor.
     */
    public Velocity() {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * constructs velocity by using the change in the x and y values.
     * @param dx
     * @param dy
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * returns dx value of velocity.
     * @return dx
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * returns dy value of velocity.
     * @return dy
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * this function gets the upcoming point based on the velocity.
     * @param p center point
     * @return new point of the center of the ball
     */
    public Point applyToPoint(Point p) {
        Point point = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return point;
    }

    /**
     * this function creates velocity from angle and speed.
     * @param angle of ball
     * @param speed of ball
     * @return new velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double angleRad = Math.toRadians(angle - 90.0);
        double dx = Math.sin(angleRad) * speed;
        double dy = -Math.cos(angleRad) * speed;
        return new Velocity(dx, dy);
    }
}
