// 328808159 Moshe Charish

import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;

/**
 * Creates an animation runner object.
 */
public class AnimationRunner {

    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;
    private int frames;

    /**
     * constructor.
     *
     * @param gui
     * @param framesPerSecond
     * @param sleeper
     */
    public AnimationRunner(GUI gui, int framesPerSecond, Sleeper sleeper) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
        this.sleeper = sleeper;
        this.frames = 60;
    }

    /**
     * runs the code.
     * @param animation the animation interface
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 60;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
