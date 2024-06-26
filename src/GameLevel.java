// 328808159 Moshe Charish

import biuoop.GUI;
import biuoop.Sleeper;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
//import java.awt.Point;

import java.util.List;
import java.util.Random;

/**
 * this class organizes the game.
 */
public class GameLevel implements Animation {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int SURROUNDING = 50;
    public static final int HEIGHTOFPAD = 10;
    public static final int WIDTHOFPAD = 100;

    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Sleeper sleeper;
    private Counter blockCounters;
    private Counter ballCounters;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation level;
    // private BlockRemover blockRemover;

    /**
     * constructor.
     * @param level the current level
     * @param animationRunner
     * @param keyboardSensor
     * @param counter
     */
    public GameLevel(LevelInformation level, AnimationRunner animationRunner,
                     KeyboardSensor keyboardSensor, Counter counter) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blockCounters = new Counter(0);
        this.ballCounters = new Counter(0);
        this.score = counter;
        this.sleeper = new Sleeper();
        this.level = level;
        this.keyboard = keyboardSensor;
        this.runner = animationRunner;

    }


    /**
     * adds colidable.
     *
     * @param c
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * adds sprite.
     *
     * @param s
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }


    /**
     * this function initializes all the objects in the game.
     */
    public void initialize() {
        background();
        createBlocks();
        createBalls();
        surroundingBlocks();
        getPaddle();
        createScoreIndicator();
//this.runner = new AnimationRunner(gui,60,sleeper);
//this.keyboard = this.gui.getKeyboardSensor();

    }

    /**
     * creates the background of the screen.
     */
    public void background() {
        Block rect = (Block) this.level.getBackground();
        this.addSprite(rect);
    }

    /**
     * Creates the 3 balls.
     */
    public void createBalls() {

        int numOfBalls = level.numberOfBalls();
        this.ballCounters = new Counter(0);
        this.ballCounters.increase(numOfBalls);
        List<Velocity> ballVel = this.level.initialBallVelocities();
        int rad = 6;
        double x = WIDTH / 2 + 50;
        double y = HEIGHT / 2 + 100;
        Random rand = new Random();
        for (int i = 0; i < numOfBalls; i++) {


            //for (Ball eachball: balls) {

            Ball ball = new Ball(x, y, Color.YELLOW, rad, this.environment);
            // double speed = 5;
            //  double angle = rand.nextInt(360);
            ball.setVelocity(ballVel.get(i));
            ball.addtogame(this);
            ball.setGameEnvironment(this.environment);

        }
       // this.ballCounters.decrease(this.level.numberOfBalls());
    }

//    /**
//     * this function creates the second ball.
//     * @return the second ball
//     */
//    public Ball createBall2() {
//        //  Ball[] balls = new Ball[3];
//        Random rand = new Random();
//        //for (Ball eachball: balls) {
//        int rad = 6;
//        double x = WIDTH / 2 + 40;
//        double y = HEIGHT / 2 + 90;
//        Ball ball2 = new Ball(x, y, Color.GREEN, rad, this.environment);
//        double speed = 5;
//        double angle = rand.nextInt(360);
//        ball2.setVelocity(Velocity.fromAngleAndSpeed(angle, speed));
//        ball2.addtogame(this);
//        return ball2;
//    }

    /**
     * this function creates the surrounding blocks so the ball stays in frame.
     * // * @param ball1
     * //* @param ball2
     */
    public void surroundingBlocks() {
        Rectangle[] surround = new Rectangle[4];
        BallRemover ballRemover = new BallRemover(this.ballCounters, this);

        surround[0] = new Rectangle(new Point(0, 0), WIDTH, SURROUNDING);
        surround[1] = new Rectangle(new Point(0, HEIGHT - SURROUNDING), this.WIDTH, SURROUNDING);
        surround[2] = new Rectangle(new Point(WIDTH - SURROUNDING, 0), SURROUNDING, HEIGHT);
        surround[3] = new Rectangle(new Point(0, 0), SURROUNDING, HEIGHT);
        for (int i = 0; i < 4; i++) {
            Block contains = new Block(surround[i], Color.GRAY);
            if (i == 1) {
                contains.addHitListener(ballRemover);
            }
            contains.addToGame(this);

        }


    }

    /**
     * Creates the blocks.
     */
    public void createBlocks() {
        this.blockCounters = new Counter(0);
        this.blockCounters.increase(this.level.numberOfBlocksToRemove());
        BlockRemover remover = new BlockRemover(this, this.blockCounters);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
//        int widthBlock = 50;
//        int heightBlock = 20;
//        Color[] colors = new Color[]{Color.YELLOW, Color.BLUE, Color.RED, Color.GREEN, Color.PINK};
//        for (int i = 0; i < 5; i++) {
//            int y = 180 + (i * heightBlock);
//            Color col = colors[i];
//            for (int j = 0; j < 12 - i; j++) {
//                int x = 700 - (j * widthBlock);
//                Block b = new Block(new Rectangle(new Point(x, y), widthBlock, heightBlock), col);
        List<Block> levelBlocks = this.level.blocks();
        for (Block b : levelBlocks) {
            b.addToGame(this);
            b.addHitListener(remover);
            //    this.blockCounters.increase(1);
            b.addHitListener(scoreTrackingListener);
           // this.blockCounters.decrease(1);
        }
//
//            }
//        }

    }

//

    /**
     * creates paddle.
     * //* @param ball1
     * //  * @param ball2
     */
    public void getPaddle() {
        Point upperLeftOfRec = new Point((WIDTH - (2 * SURROUNDING) - level.paddleWidth()) / 2,
                HEIGHT - HEIGHTOFPAD - SURROUNDING);
        Rectangle paddleShape = new Rectangle(upperLeftOfRec, level.paddleWidth(), HEIGHTOFPAD);
        Paddle pad = new Paddle(paddleShape, SURROUNDING, Color.RED, gui, this.keyboard);
        pad.setGameenvironment(this.environment);
        pad.addToGame(this);
        // this.environment.addCollidable(pad);
        // this.sprites.addSprite(pad);
        // ball1.getgameEnvironment().addCollidable(pad);
        // ball2.getgameEnvironment().addCollidable(pad);

    }

    /**
     * Creates the score indicator.
     */
    public void createScoreIndicator() {
        ScoreIndicator indicator = new ScoreIndicator(this.score,
                new Rectangle(new Point(0, 0), 800, 20), Color.white, this.level.levelName());
        indicator.addToGame(this);
    }

    /**
     * runs the game.
     */
    public void run() {
        //  this.createBlocks();

        this.running = true;
        this.runner.run(this);
        // while (this.running == true) {

        //  }
//        int framesPerSecond = 60;
//        Sleeper sleeper = new Sleeper();
//        int millisecondsPerFrame = 1000 / framesPerSecond;
//        while (true) {
//            long startTime = System.currentTimeMillis(); // timing
//
//            DrawSurface d = gui.getDrawSurface();
//            d.setColor(new Color(1, 19, 73));
//            d.fillRectangle(0, 0, WIDTH, HEIGHT);
//            this.sprites.drawAllOn(d);
//            gui.show(d);
//
//            this.sprites.notifyAllTimePassed();
//            //  System.out.println(this.score.getValue());
//
//            // timing
//            long usedTime = System.currentTimeMillis() - startTime;
//            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
//            if (milliSecondLeftToSleep > 0) {
//                sleeper.sleepFor(milliSecondLeftToSleep);
//            }
//        }
    }

    /**
     * removes the collidable.
     *
     * @param c collidable
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeC(c);

    }

    /**
     * removes the sprite.
     *
     * @param s sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeS(s);
    }

    @Override
    public void doOneFrame(DrawSurface d) {

        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            // this.runner.run(new PauseScreen(this.keyboard));
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                    new PauseScreen(keyboard), KeyboardSensor.SPACE_KEY));
        }
        if (this.blockCounters.getValue() == 0) {
            this.score.increase(100);
            //  System.out.println(this.score.getValue());
//            gui.close();
//            return;
            this.running = false;
        }
        if (this.ballCounters.getValue() == 0) {
            this.running = false;
//            this.runner.run(new EndScreen(this.running, this.score.getValue(),  this.keyboard));
//
        }

    }

    @Override
    public boolean shouldStop() {
        return !(this.running);
    }

    /**
     * gets the number of balls.
     * @return number of balls
     */
    public int getValBall() {
        return this.ballCounters.getValue();
    }
    /**
     * gets the number of blocks.
     * @return number of blocks
     */
    public int getValBlock() {
        return this.blockCounters.getValue();
    }
}




