// 328808159 Moshe Charish

/**
 * this class creates a ball remover object.
 */
public class BlockRemover implements HitListener {

    private GameLevel game;
    private Counter remainingBlocks;

   /**
    * constructor.
    * @param game the game
    * @param removedBlocks counter of the blocks being removed
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * this function removes objects from the game after that block is hit.
     * @param beingHit the block being hit
     * @param hitter the ball that is hitting the block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBlocks.decrease(1);
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(game);

    }
}
