// 328808159 Moshe Charish

import java.util.ArrayList;
import java.util.List;

/**
 * this class creates a rectangle.
 */
public class Rectangle {

    private Line top;
    private Line bottom;
    private Line left;
    private Line right;
    private Point upperleft;

    /**
     * constructs a rect using a point, width and height.
     *
     * @param upperLeft point
     * @param width
     * @param height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperleft = upperLeft;
        Point topright = new Point(width + upperLeft.getX(), upperLeft.getY());
        this.top = new Line(upperLeft, topright);
        Point bottomleft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        this.left = new Line(upperLeft, bottomleft);
        Point bottomright = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        this.right = new Line(topright, bottomright);
        this.bottom = new Line(bottomleft, bottomright);
    }



    /**
     * creates list of intersection points between a line and the rect.
     *
     * @param line
     * @return list of points
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> list = new ArrayList<Point>();
        if (line.isIntersecting(this.top)) {
            list.add(line.intersectionWith(top));
        }
        if (line.isIntersecting(this.bottom)) {
            list.add(line.intersectionWith(bottom));
        }
        if (line.isIntersecting(this.right)) {
            list.add(line.intersectionWith(right));
        }
        if (line.isIntersecting(this.left)) {
            list.add(line.intersectionWith(left));
        }
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    /**
     * returns width of rect.
     *
     * @return width
     */
    public double getWidth() {
        return this.top.length();
    }

    /**
     * returns height of rect.
     *
     * @return height
     */
    public double getHeight() {
        return this.right.length();
    }

    /**
     * returns upperleft point.
     *
     * @return point
     */
    public Point getUpperLeft() {
        // return this.left.intersectionWith(this.top);
        return this.upperleft;
    }

    /**
     * checks if point is in rect.
     *
     * @param p
     * @return true if yes and false if not
     */
    public boolean online(Point p) {
        if (p.getX() >= getUpperLeft().getX() && p.getX() <= getUpperLeft().getX() + this.getWidth()
                && p.getY() >= getUpperLeft().getY() && p.getY() <= getUpperLeft().getY() + this.getHeight()) {
            return true;
        }
        return false;
    }


    /**
     * checks if point collides with lines of rect.
     *
     * @param collision point
     * @return true if collides and false if not
     */
    public boolean hitblock(Point collision) {
        int count = 0;
        if (collision.getX() >= this.upperleft.getX() && collision.getX() <= this.upperleft.getX() + getWidth()) {
            count++;
        }
        if (collision.getY() >= this.upperleft.getY() && collision.getY() <= this.upperleft.getY() + getHeight()) {
            count++;
        }
        if (count == 2) {
            return true;
        }
        return false;
    }

    /**
     * list of the lines that create the rect.
     * @return line list
     */
    public java.util.List<Line> lines() {
        List<Line> lines = new ArrayList<>();
        lines.add(this.top);
        lines.add(this.bottom);
        lines.add(this.left);
        lines.add(this.right);
        return lines;
    }
}