// 328808159 Moshe Charish



/**
 * This class finds the distance between given point and if they are equal.
 */
public class Point {

private double x;
private double y;

    /**
     * constructor.
     * @param x location of point
     * @param y location of point
     */
    public Point(double x, double y) {
     this.x = x;
    this.y = y;
}

    /**
     * This function finds the distance between points.
     * @param other point
     * @return distance
     */
    public double distance(Point other) {
double disx, disy, totaldis;
disx = this.x - other.getX();
        disy = this.y - other.getY();
        totaldis = Math.sqrt((disx * disx) + (disy * disy));
        return totaldis;
    }

    /**
     * Checks if points are equal.
     * @param other point
     * @return false if not equal and true if equal.
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;

        } else {
            if (this.x == other.getX() && this.y == other.getY()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the x coordination.
     * @return x coordination
     */
    public double getX() {
    return this.x;
    }

    /**
     * Gets the y coordination.
     * @return y coordination
     */
    public double getY() {
        return this.y;
    }
}
