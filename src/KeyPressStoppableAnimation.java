// 328808159 Moshe Charish


import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * creates object in charge of closing screen when space is pressed.
 */
public class KeyPressStoppableAnimation implements Animation {

    private KeyboardSensor key;
    private Animation animation;
    private String str;
    private boolean bool;
    private boolean bool2;

    /**
     * constructor.
     * @param keyboardSensor
     * @param animation
     * @param s
     */
    public KeyPressStoppableAnimation(KeyboardSensor keyboardSensor, Animation animation, String s) {
        this.animation = animation;
        this.key = keyboardSensor;
        this.str = s;
        this.bool = false;
        this.bool2 = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.key.isPressed(str)) {
            if (!this.bool2) {
                this.bool = true;
            }
        } else {
                this.bool2 = false;
            }
        this.animation.doOneFrame(d);
    }

    @Override
    public boolean shouldStop() {
        return this.bool;
    }
}
