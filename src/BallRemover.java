// 328808159 Moshe Charish

/**
 * this class creates a ball remover object.
 */
public class BallRemover implements HitListener {

    private Counter remainingBalls;
    private GameLevel game;

    /**
     * constructor.
     *
     * @param remainingBalls counter
     * @param g              game
     */
    public BallRemover(Counter remainingBalls, GameLevel g) {
        this.remainingBalls = remainingBalls;
        this.game = g;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
