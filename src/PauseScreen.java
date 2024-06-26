// 328808159 Moshe Charish

import biuoop.KeyboardSensor;
import biuoop.DrawSurface;

/**
 * creates a pause screen.
 */
public class PauseScreen implements Animation {

    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * constructor.
     * @param k
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * runs a frame.
     * @param d drawface
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * decides if to stop.
     * @return true or false
     */
    public boolean shouldStop() {
        return this.stop;
    }
}

