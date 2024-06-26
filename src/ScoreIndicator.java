// 328808159 Moshe Charish

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Creates a scoreIndicator object.
 */
public class ScoreIndicator implements Sprite {
    private Counter points;
    private Rectangle rect;
    private Color col;
    private String name;

    /**
     * constructor.
     * @param scores counter
     * @param rect rectangle
     * @param col color of rectangle
     * @param name
     */
    public ScoreIndicator(Counter scores, Rectangle rect, Color col, String name) {
        this.points = scores;
        this.rect = rect;
        this.col = col;
        this.name = name;
    }

    /**
     * draws rectangle with the score writing.
     * @param d drawface
     */
    @Override
    public void drawOn(DrawSurface d) {
        int xpoint = (int) this.rect.getUpperLeft().getX();
        int ypoint = (int) this.rect.getUpperLeft().getY();
        int redHeight = (int) this.rect.getHeight();
        int recWidth = (int) this.rect.getWidth();
        d.setColor(this.col);
        d.fillRectangle(xpoint, ypoint, recWidth, redHeight);
        String writing = "Score:" + this.points.getValue();
        d.setColor(Color.black);
        d.drawText((recWidth - (writing.length() * 70)), ypoint + redHeight - 3, writing, 15);
        String levelName = "Level Name: " + this.name;
        d.setColor(Color.black);
        d.drawText((recWidth - (writing.length() * 25)), ypoint + redHeight - 3, levelName, 15);
    }

    @Override
    public void timePassed() {

    }

    /**
     * adds sprite to game.
     * @param game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

}
