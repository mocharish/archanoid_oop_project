// 328808159 Moshe Charish

/**
 * This class creates a counter object.
 */
public class Counter {

    private int val;

    /**
     * constructor.
     * @param val value of the counter
     */
    public Counter(int val) {
        this.val = val;
    }

    /**
     * increases the value of the counter.
     * @param num that we are adding to the value
     */
    public void increase(int num) {
        this.val = this.val + num;
    }

    /**
     * decreases the value of the counter.
     * @param num that we are adding to the value
     */
    public void decrease(int num) {
        this.val = this.val - num;
    }

    /**
     * gets value of the counter.
     * @return value
     */
    public int getValue() {
        return this.val;
    }
}
