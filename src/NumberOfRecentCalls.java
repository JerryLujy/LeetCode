import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <h1>933. Number of Recent Calls</h1>
 * Write a class RecentCounter to count recent requests.
 * It has only one method: ping(int t), where t represents some time in milliseconds.
 * Return the number of pings that have been made from 3000 milliseconds ago until now.
 * Any ping with time in [t - 3000, t] will count, including the current ping.
 * It is guaranteed that every call to ping uses a strictly larger value of t than before.
 * <p>
 * Example 1:
 * Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * Output: [null,1,2,3,3]
 * <p>
 * Note:
 * Each test case will have at most 10000 calls to ping.
 * Each test case will call ping with strictly increasing values of t.
 * Each call to ping will have 1 <= t <= 10^9.
 *
 * @author Jerry
 * @since 2/4/19
 */
public class NumberOfRecentCalls {
    Queue<Integer> calls;

    public NumberOfRecentCalls() {
        calls = new ArrayDeque<>();
    }

    public int ping(int t) {
        calls.offer(t);
        while (calls.peek() < t - 3000) {
            calls.poll();
        }
        return calls.size();
    }
}
