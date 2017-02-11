import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * <h1>281. Zigzag Iterator</h1>
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * <p>
 * For example, given two 1d vectors: v1 = [1, 2], v2 = [3, 4, 5, 6],
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 * <p>
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 *
 * @author Jerry
 * @since 2/10/17
 */
public class ZigzagIterator {
    private Queue<Iterator<Integer>> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new ArrayDeque<>();
        if (!v1.isEmpty()) {
            queue.offer(v1.iterator());
        }
        if (!v2.isEmpty()) {
            queue.offer(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> currIter = queue.poll();
        int val = currIter.next();
        if (currIter.hasNext()) {
            queue.offer(currIter);
        }
        return val;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
