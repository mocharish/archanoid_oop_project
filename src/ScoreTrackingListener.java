// 328808159 Moshe Charish

/**
 * this function creates score tracking object.
 */
public class ScoreTrackingListener implements HitListener {

    private Counter currentScore;

    /**
     * constructor.
     * @param currentScore of the game
     */
    public ScoreTrackingListener(Counter currentScore) {
        this.currentScore = currentScore;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }

    /**
     * increases score.
     */
    public void finishedBlocks() {
        this.currentScore.increase(100);
    }

    /**
     * gets the score.
     * @return the score
     */
    public Counter getCurrentScore() {
        return currentScore;
    }
}
