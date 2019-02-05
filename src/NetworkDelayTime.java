import java.util.*;

/**
 * <h1>743. Network Delay Time</h1>
 * There are N network nodes, labelled 1 to N.
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node,
 * v is the target node, and w is the time it takes for a signal to travel from source to target.
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 * <p>
 * Note:
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
 *
 * @author Jerry
 * @since 2/4/19
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], k -> new HashMap<>()).put(time[1], time[2]);
        }
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(e -> e[1])); // (node, time)
        q.offer(new int[]{K, 0});
        Map<Integer, Integer> dist = new HashMap<>();
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (dist.containsKey(cur[0])) {
                continue;
            }
            dist.put(cur[0], cur[1]);
            if (!graph.containsKey(cur[0])) {
                continue;
            }
            for (Integer next : graph.get(cur[0]).keySet()) {
                if (!dist.containsKey(next)) {
                    q.offer(new int[]{next, graph.get(cur[0]).get(next) + cur[1]});
                }
            }
        }
        if (dist.size() != N) {
            return -1;
        }
        int ans = 0;
        for (int cand: dist.values()) {
            ans = Math.max(ans, cand);
        }
        return ans;
    }
}
