// 328808159 Moshe Charish

import biuoop.KeyboardSensor;

import java.util.List;

/**
 * this class is in charge of the setting of the game.
 */
public class GameFlow {

    private AnimationRunner animationRunner;
    private KeyboardSensor key;
    private Counter totalScore;

    /**
     * constructor.
     * @param animationRunner
     * @param key
     */
    public GameFlow(AnimationRunner animationRunner, KeyboardSensor key) {
        this.animationRunner = animationRunner;
        this.key = key;
        this.totalScore = new Counter(0);
    }

    /**
     * runs the game by switching the levels.
     * @param levels
     */
    public void runLevels(List<LevelInformation> levels) {
        int i = 0;
        for (LevelInformation levelInfo : levels) {
int j = levels.size();
            GameLevel level = new GameLevel(levelInfo, this.animationRunner, this.key, this.totalScore);

            level.initialize();

            while (level.getValBall() > 0 && level.getValBlock() > 0) {
//                if (level.getValBlock() == 1) {
//                    break;
//                }
                level.run();

            }


            if (level.getValBall() == 0) {
                this.animationRunner.run(new KeyPressStoppableAnimation(this.key,
                        new EndScreen(false, this.totalScore.getValue(), this.key), KeyboardSensor.SPACE_KEY));

                break;
            }
            i++;
            if (i == j && level.getValBlock() == 0) {
                this.animationRunner.run(new KeyPressStoppableAnimation(this.key,
                        new EndScreen(true, this.totalScore.getValue(), this.key), KeyboardSensor.SPACE_KEY));
                break;
            }


        }
    }

}

