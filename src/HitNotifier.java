// 328808159 Moshe Charish

/**
 * represents a hit notifier interface.
 */
public interface HitNotifier {
    /**
     *   Add hl as a listener to hit events.
     * @param hl listener
     */
    void addHitListener(HitListener hl);
    /**
     *   Remove hl from the list of listeners to hit events.
     * @param hl listener
     */
    void removeHitListener(HitListener hl);
}
