// 328808159 Moshe Charish


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The final green 3, the third level.
 */
public class Green3 implements LevelInformation {

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
    public Green3() {
        this.ballsNum = 2;
        this.nameOfLevel = "Green 3";
        this.paddleSize = 90;
        this.paddleSpeed = 6;
        this.blocksToRemove = 40;

        this.ballsVelocity = new ArrayList<>();
        for (int i = 0; i < this.ballsNum; i++) {
            Velocity vel = Velocity.fromAngleAndSpeed(330 - (300 * i), 9);
            this.ballsVelocity.add(vel);
        }
        int widthBlock = 50;
        int heightBlock = 20;
        Color[] colors = new Color[]{Color.GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.WHITE};
        this.blocks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int y = 180 + (i * heightBlock);
            Color col = colors[i];
            for (int j = 0; j < 10 - i; j++) {
                int x = 700 - (j * widthBlock);
                Block b = new Block(new Rectangle(new Point(x, y), widthBlock, heightBlock), col);
                this.blocks.add(b);
            }
        }
        this.col = Color.GREEN;
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
