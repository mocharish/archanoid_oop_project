// 328808159 Moshe Charish

/**
 * This class creates a line out of two points.
 * Finds the middle of a line.
 * checks if two lines intersect.
 * finds the intersecting point of two lines.
 */
public class Line {

    private Point start;
    private Point end;

    /**
     * new line.
     *
     * @param start point
     * @param end   point
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * new line from 4 coordinates.
     *
     * @param x1 x coordinate of first point
     * @param y1 y coordinate of first point
     * @param x2 x coordinate of second point
     * @param y2 y coordinate of second point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * This function finds length of line.
     *
     * @return the length
     */
    public double length() {
        double len;
        len = this.start.distance(this.end);
        return len;
    }

    /**
     * This function finds middle point of line.
     *
     * @return middle point
     */
    public Point middle() {
        double xmid, ymid;
        xmid = (this.start.getX() + this.end.getX()) / 2;
//xmid = xmid / 2;
        ymid = (this.start.getY() + this.end.getY()) / 2;
//ymid = ymid / 2;
        Point mid = new Point(xmid, ymid);
        return mid;

    }

    /**
     * gets the start point.
     *
     * @return start point
     */
    public Point start() {
        return this.start;
    }

    /**
     * gets the end point.
     *
     * @return end point
     */

    public Point end() {
        return this.end;
    }

    /**
     * this function checks if one parallel line contains the other.
     *
     * @param other line
     * @return true if contains and false if not
     */
    public boolean containedinparallel(Line other) {
        if (other == null) {
            return false;
        }
        double thisx = this.start.getX() - this.end.getX();
        double thisy = this.end.getY() - this.start.getY();
        double otherx = other.start.getX() - other.end.getX();
        double othery = other.end.getY() - other.start.getY();
        double denom = (thisy * otherx) - (thisx * othery);
        double thisz = (thisy * this.start.getX()) + (thisx * this.start.getY());
        double otherz = (othery * other.start.getX()) + (otherx * other.start.getY());
        if (denom == 0) {
            if (this.isonline(other.end) == 1 && this.isonline(other.start) == 1) {
                return true;
            } else {
                if (other.isonline(this.end) == 1 && other.isonline(this.start) == 1) {
                    return true;
                } else {
                    if (this.isonline(other.start) == 1 && (other.isonline(this.start) == 1
                            || other.isonline(this.end) == 1)) {
                        return true;
                    } else if (this.isonline(other.end) == 1 && (other.isonline(this.start) == 1
                            || other.isonline(this.end) == 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if two lines intersect.
     *
     * @param other line
     * @return true if intersects and if it does not.
     */
    public boolean isIntersecting(Line other) {
        if (other == null) {
            return false;
        }
        int spot = 0;
        Point x = intersectionWith(other);
        if (this.equals(other)) {
            spot = 1;
        }

        if (x == null && spot == 0 && !containedinparallel(other)) {
            return false;
        }
        return true;
    }

    /**
     * Checks if point is on a certain line.
     *
     * @param p point
     * @return 1 if true , 0 if false
     */
    public int isonline(Point p) {
        double maxx = Math.max(this.start.getX(), this.end.getX());
        double minx = Math.min(this.start.getX(), this.end.getX());
        double maxy = Math.max(this.start.getY(), this.end.getY());
        double miny = Math.min(this.start.getY(), this.end.getY());
        if (p.getX() >= minx && p.getX() <= maxx && p.getY() <= maxy && p.getY() >= miny) {
            return 1;
        }
        return 0;
    }


    /**
     * Finds intersecting point.
     *
     * @param other point
     * @return intersecting point
     */
    public Point intersectionWith(Line other) {
        if (other == null) {
            return null;
        }
        Point inter;
        double thisx = this.start.getX() - this.end.getX();
        double thisy = this.end.getY() - this.start.getY();
        double otherx = other.start.getX() - other.end.getX();
        double othery = other.end.getY() - other.start.getY();
        double denom = (thisy * otherx) - (thisx * othery);
        double thisz = (thisy * this.start.getX()) + (thisx * this.start.getY());
        double otherz = (othery * other.start.getX()) + (otherx * other.start.getY());
//        if (thisx == 0 && otherx == 0) {
//            if (other.start.getX() != this.start.getX() && other.start.getX() != this.end.getX()) {
//                return null;
//            } else {
//                if (this.equals(other)) {
//                    return null;
//                } else {
//                    if ((Math.max(this.start.getY(), this.end.getY())
//                            == Math.min(other.start.getY(), other.end.getY()))) {
//                        inter = new Point(this.start.getX(), (Math.min(other.start.getY(), other.end.getY())));
//                        return inter;
//                    } else {
//                        if ((Math.min(this.start.getY(), this.end.getY())
//                                == Math.max(other.start.getY(), other.end.getY()))) {
//                            inter = new Point(this.start.getX(), (Math.min(this.start.getY(), this.end.getY())));
//                            return inter;
//
//
//                        } else {
//                            if ((Math.max(this.start.getY(), this.end.getY())
//                                    < Math.min(other.start.getY(), other.end.getY()))
//                                    && (Math.min(this.start.getY(), this.end.getY())
//                                    > Math.max(other.start.getY(), other.end.getY()))) {
//                                return null;
//                            } else {
//                                if ((Math.max(this.start.getY(), this.end.getY())
//                                        > Math.min(other.start.getY(), other.end.getY()))
//                                        || (Math.min(this.start.getY(), this.end.getY())
//                                        < Math.max(other.start.getY(), other.end.getY()))) {
//                                    return null;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//else {
        if (this.start.equals(other.start)) {
            inter = new Point(this.start.getX(), this.start.getY());
            return inter;
        } else {
            if (this.start.equals(other.end)) {
                inter = new Point(this.start.getX(), this.start.getY());
                return inter;
            } else {
                if (this.end.equals(other.end) || this.end.equals(other.start)) {
                    inter = new Point(this.end.getX(), this.end.getY());
                    return inter;
                }
            }
        }

        if (denom == 0) {
            return null;
        } else {

            double touchingx = (thisz * otherx - otherz * thisx) / denom;
            double touchingy = (otherz * thisy - thisz * othery) / denom;
            inter = new Point(touchingx, touchingy);
            double truethis = this.isonline(inter);
            double trueother = other.isonline(inter);
            if (trueother == 1 && truethis == 1) {
                return inter;
            } else {
                return null;
            }
        }
    }
//return null;
//    }

    /**
     * Checks if two lines are equal.
     *
     * @param other line
     * @return true if equal and false if not
     */
    public boolean equals(Line other) {

        if (other == null) {
            return false;
        } else {
            if ((this.start.equals(other.start) && this.end.equals(other.end))
                    || (this.start.equals(other.end) && this.end.equals(other.start))) {
                return true;
            }
        }
        return false;
    }

    /**
     * checks if ball hits the left line of the rect.
     *
     * @param collision point
     * @return 1 if yes, 0 if no
     */
    public int hitleft(Point collision) {
        if (collision.getX() >= this.start().getX() && collision.getY()
                >= this.start.getY() && collision.getY() <= this.end.getY()) {
            return 1;
        }
        return 0;
    }

    /**
     * checks if ball hits the right line of the rect.
     *
     * @param collision point
     * @return 1 if yes, 0 if no
     */
    public int hitright(Point collision) {
        if (collision.getX() >= this.start().getX() && collision.getY()
                >= this.start.getY() && collision.getY() <= this.end.getY()) {
            return 1;
        }
        return 0;
    }

    /**
     * checks if ball hits the top line of the rect.
     *
     * @param collision point
     * @return 1 if yes, 0 if no
     */
    public int hittop(Point collision) {
        if (collision.getX() >= this.start().getX() && collision.getX()
                <= this.end.getX() && collision.getY() >= this.end.getY()) {
            return 1;
        }
        return 0;
    }

    /**
     * gets closest collision point to the start of the line.
     *
     * @param rect
     * @return closest collision point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Point closest;
        java.util.List<Point> intersectionPoints = rect.intersectionPoints(this);
        if (intersectionPoints == null) {
            return null;
        }
        closest = intersectionPoints.get(0);
        double closedis = this.start.distance(closest);
        for (int i = 1; i < intersectionPoints.size(); i++) {
            if (this.start.distance(intersectionPoints.get(i)) < closedis) {
                // intersectionPoints.get(i).distance(this.start)
                closedis = intersectionPoints.get(i).distance(this.start);
                closest = intersectionPoints.get(i);
            }
        }
        return closest;
    }

}
