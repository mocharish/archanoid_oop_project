// 328808159 Moshe Charish

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * this class creates the game environment.
 */
public class GameEnvironment {

    private List<Collidable> collidableList = new ArrayList<Collidable>();

    /**
     * constructs new game environment.
     */
    public GameEnvironment() {
        this.collidableList = new ArrayList<Collidable>();

    }

    /**
     * gets the game environment.
     * @return list of collidables
     */
    public List<Collidable> getenvironment() {
        return this.collidableList;
    }

    /**
     * makes list of collidables.
     *
     * @return the list.
     */
    public List<Collidable> getCollidableList() {
        return this.collidableList;
    }

    /**
     * adds collidable to list.
     *
     * @param c
     */
    public void addCollidable(Collidable c) {
        collidableList.add(c);
    }


    /**
     * gets the closest collision.
     *
     * @param trajectory line
     * @return new collision info of point and object
     */
    public CollisionInfo getClosestCollision(Line trajectory) {

        for (int i = 0; i < collidableList.size(); i++) {

            Point collisionpoint = trajectory.closestIntersectionToStartOfLine(
                    collidableList.get(i).getCollisionRectangle());

            if (collisionpoint != null) {
                CollisionInfo info = new CollisionInfo(collisionpoint, collidableList.get(i));
                return info;
            }

        }
        return null;

    }

    /**
     * this function makes sure the ball does not get stuck in block and
     * if it does we place it in a random different spot.
     *
     * @param ball
     */
    public void stuckinblock(Ball ball) {
        Random random = new Random();
        if (this.collidableList.isEmpty()) {
            return;
        }
        for (Collidable collide : collidableList) {
            if (collide.getCollisionRectangle().hitblock(ball.getP())) {
                ball.setCenter(random.nextInt(200) + 300, 400);
            }
        }
    }

    /**
     * gets list of the collidables.
     * @return list
     */
    public List<Collidable> collidablegetter() {
        return this.collidableList;
    }
    /**
     * removes collidable.
     * @param c collidable
     */
    public void removeC(Collidable c) {
        this.collidableList.remove(c);
    }


}
