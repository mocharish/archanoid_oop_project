// 328808159 Moshe Charish



import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

/**
 * The direct hit level, the first level.
 */
public class DirectHit implements LevelInformation {

    private int ballsNum;
    private String nameOfLevel;
    private List<Velocity> ballsVelocity;
    private int paddleSize;
    private int paddleSpeed;
    private List<Block> blocks;
    private Sprite background;
    private int blocksToRemove;
    private Color col;

    /**
     * constructor.
     */
    public DirectHit() {
        this.ballsNum = 1;
        this.nameOfLevel = "Direct Hit";
        this.paddleSpeed = 6;
        this.paddleSize = 90;
        this.blocksToRemove = 1;
        this.blocks = new ArrayList<>();
        Point blockUpperLeft = new Point(390, 150);
        Rectangle rec = new Rectangle(blockUpperLeft, 20, 20);
        Block block = new Block(rec, Color.red);
        this.blocks.add(block);
        this.ballsVelocity = new ArrayList<>();
        Velocity vel = Velocity.fromAngleAndSpeed(76, 9);
        this.ballsVelocity.add(vel);
        this.col = Color.BLACK;
        Point tar = new Point(400, 160);
//this.background = new Target(50, tar);

    }

    @Override
    public int numberOfBalls() {
        return this.ballsNum;
    }

    @Override
    public List<Velocity> initialBallVelocities() {

        return this.ballsVelocity;
    }

    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return this.paddleSize;
    }

    @Override
    public String levelName() {
        return this.nameOfLevel;
    }

    @Override
    public Sprite getBackground() {
        Rectangle rect = new Rectangle(new Point(50, 50), 700, 700);
        Block ground = new Block(rect, this.col);
        return ground;
    }

    @Override
    public List<Block> blocks() {

        return this.blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocksToRemove;
    }
}
