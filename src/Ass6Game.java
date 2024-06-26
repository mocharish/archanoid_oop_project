// 328808159 Moshe Charish

import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.util.ArrayList;
import java.util.List;

/**
 * This class runs the code.
 */

public class Ass6Game {


    /**
     * this is the main method that runs the code.
     *
     * @param args input from the user
     */
    public static void main(String[] args) {
        GUI gui = new biuoop.GUI("Game", 800, 600);
        AnimationRunner runner = new AnimationRunner(gui, 60, new Sleeper());
        KeyboardSensor keyboard = gui.getKeyboardSensor();
        List<LevelInformation> thisLevel = new ArrayList<>();
        for (String arg : args) {
            if (arg.length() == 1) {
                if (Character.isDigit((char) arg.charAt(0))) {
                    int index = Integer.valueOf(arg);
                    if (index > 0 && index < 5) {
                        switch (index) {
                            case 1:
                                thisLevel.add(new DirectHit());
                                break;
                            case 2:
                                thisLevel.add(new WideEasy());
                                break;
                            case 3:
                                thisLevel.add(new Green3());
                                break;
                            case 4:
                                thisLevel.add(new FinalFour());
                                break;
                            default: break;

                        }

                    }
                }
            }
        }
        if (thisLevel.isEmpty()) {
            thisLevel.add(new DirectHit());
            thisLevel.add(new WideEasy());
            thisLevel.add(new Green3());
            thisLevel.add(new FinalFour());
        }
        GameFlow game = new GameFlow(runner, keyboard);
        game.runLevels(thisLevel);

        // game.run();
        gui.close();

    }
}
