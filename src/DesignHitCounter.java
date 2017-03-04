/**
 * <h1>362. Design Hit Counter</h1>
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to
 * the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
 * <p>
 * It is possible that several hits arrive roughly at the same time.
 * <p>
 * Example:
 * <pre>
 * HitCounter counter = new HitCounter();
 * // hit at timestamp 1.
 * counter.hit(1);
 * // hit at timestamp 2.
 * counter.hit(2);
 * // hit at timestamp 3.
 * counter.hit(3);
 * // get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 * // hit at timestamp 300.
 * counter.hit(300);
 * // get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 * // get hits at timestamp 301, should return 3.
 * counter.getHits(301);
 * </pre>
 *
 * @author Jerry
 * @since 3/3/17
 */
public class DesignHitCounter {
    private int[] hits;
    private int[] lastTime;

    /**
     * Initialize your data structure here.
     */
    public DesignHitCounter() {
        hits = new int[300];
        lastTime = new int[300];
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        int ind = timestamp % 300;
        if (lastTime[ind] == timestamp) {
            hits[ind]++;
        } else {
            hits[ind] = 1;
            lastTime[ind] = timestamp;
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - lastTime[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }
}
