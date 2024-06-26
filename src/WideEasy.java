// 328808159 Moshe Charish


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The final wide easy, the second level.
 */
public class WideEasy implements LevelInformation {
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
    public WideEasy() {
        this.ballsNum = 10;
        this.nameOfLevel = "Wide Easy";
        this.paddleSpeed = 6;
        this.paddleSize = 600;
        this.blocksToRemove = 15;
        this.blocks = new ArrayList<>();
        double blockWidth = (GameLevel.WIDTH - (GameLevel.SURROUNDING * 2)) / this.blocksToRemove;
        Color col = null;
        for (int i = 0; i < 15; i++) {
            Point blockUpperLeft = new Point((GameLevel.WIDTH - GameLevel.SURROUNDING - ((i + 1) * blockWidth)), 300);
            Rectangle rec = new Rectangle(blockUpperLeft, blockWidth, 20);

            if (i == 1 || i == 0) {
                col = Color.CYAN;
            }
            if (i == 3 || i == 2) {
                col = Color.PINK;
            }
            if (i == 5 || i == 4) {
                col = Color.BLUE;
            }
            if (i == 8 || i == 6 || i == 7) {
                col = Color.GREEN;
            }
            if (i == 10 || i == 9) {
                col = Color.YELLOW;
            }
            if (i == 12 || i == 11) {
                col = Color.ORANGE;
            }
            if (i == 13 || i == 14) {
                col = Color.RED;
            }
            Block block = new Block(rec, col);
            this.blocks.add(block);
        }
        this.ballsVelocity = new ArrayList<>();
        for (int i = 0; i < this.ballsNum; i++) {
            Velocity v = Velocity.fromAngleAndSpeed(310 + (i * 15), 9);
            this.ballsVelocity.add(v);
        }
        this.col = Color.WHITE;
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


        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocksToRemove;
    }
}
