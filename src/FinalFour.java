import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The final four level, the last level.
 */
public class FinalFour implements LevelInformation {

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
    public FinalFour() {
        this.ballsNum = 3;
        this.nameOfLevel = "Final Four";
        this.paddleSize = 90;
        this.paddleSpeed = 6;
        this.blocksToRemove = 105;
        this.blocks = new ArrayList<>();
        int widthBlock = (GameLevel.WIDTH - (2 * GameLevel.SURROUNDING)) / 15;
        int heightBlock = 20;
        Color[] colors = new Color[]{Color.GRAY, Color.RED, Color.YELLOW, Color.GREEN,
                Color.WHITE, Color.PINK, Color.cyan};
        for (int i = 0; i < 7; i++) {
            int y = 150 + (i * heightBlock);
            Color col = colors[i];
            for (int j = 0; j < 15; j++) {
                int x = (j * widthBlock);
                Block b = new Block(new Rectangle(new Point(x, y), widthBlock, heightBlock), col);
                this.blocks.add(b);
            }
        }
        this.ballsVelocity = new ArrayList<>();
        for (int i = 0; i < this.ballsNum; i++) {
            Velocity vel = Velocity.fromAngleAndSpeed(100 + (45 * i), 9);
            this.ballsVelocity.add(vel);
        }
        this.col = Color.blue;
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
