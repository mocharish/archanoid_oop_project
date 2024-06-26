// 328808159 Moshe Charish

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * creates the end screen.
 */
public class EndScreen implements Animation {

    private boolean bool;
    private int score;
    private KeyboardSensor key;

    /**
     * constructor.
     * @param bool
     * @param score of the game
     * @param keyboardSensor
     */
    public EndScreen(boolean bool, int score, KeyboardSensor keyboardSensor) {
        this.bool = bool;
        this.score = score;
        this.key = keyboardSensor;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        String write = "";
        // if (this.bool) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, 800, 600);
        if (this.bool) {
            d.setColor(Color.BLACK);
            write = "You Win! Your score is " + this.score;


        } else {
            d.setColor(Color.BLACK);
            write = "Game Over. Your score is " + this.score;
        }
        d.drawText(10, 400, write, 40);
        //   if (this.key.isPressed(KeyboardSensor.SPACE_KEY)) { this.bool=true; }

    }

    @Override
    public boolean shouldStop() {
        return this.bool;
    }
}

