import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <h1>346. Moving Average from Data Stream</h1>
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * <p>
 * For example, MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1;
 * m.next(10) = (1 + 10) / 2;
 * m.next(3) = (1 + 10 + 3) / 3;
 * m.next(5) = (10 + 3 + 5) / 3
 *
 * @author Jerry
 * @since 2/26/17
 */
public class MovingAverageFromDataStream {
    private int capacity, sum;
    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MovingAverageFromDataStream(int size) {
        queue = new ArrayDeque<>();
        capacity = size;
        sum = 0;
    }

    public double next(int val) {
        queue.offer(val);
        sum += val;
        if (queue.size() > capacity) {
            sum -= queue.poll();
        }
        return (double) sum / queue.size();
    }
}
