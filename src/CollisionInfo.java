// 328808159 Moshe Charish

/**
 * this class gets info of collision.
 */
public class CollisionInfo {

    private Point collisionp;

    private Collidable collide;

    /**
     * constructs info using collision point and the object collided with.
     * @param collisionpoint of ball with object
     * @param collider object collided with
     */
    public CollisionInfo(Point collisionpoint, Collidable collider) {
        this.collisionp = collisionpoint;
        this.collide = collider;
    }

    /**
     * returns the collision point from the info.
     * @return collision point
     */
    public Point collisionPoint() {
        return this.collisionp;
    }

    /**
     * returns the collision object from info.
     * @return the object
     */
    public Collidable collisionObject() {
        return this.collide;
    }
}
