// 328808159 Moshe Charish

/**
 * this interface represents a collidable object.
 */
public interface Collidable {

    /**
     * returns the collision shape of the collidable object.
     *
     * @return the shape
     */
    Rectangle getCollisionRectangle();

    /**
     * @param hitter          the ball
     * @param collisionPoint  of ball with object
     * @param currentVelocity of ball
     * @return velocity after collision
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
