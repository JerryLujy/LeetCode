import java.util.*;

/**
 * <h1>787. Cheapest Flights Within K Stops</h1>
 * There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.
 * Now given all the cities and flights, together with starting city src and the destination dst,
 * your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 * <p>
 * Example 1: Input: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 * Output: 200
 * <p>
 * Example 2: Input: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 * Output: 500
 * <p>
 * Note:
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 *
 * @author Jerry
 * @since 1/29/19
 */
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashMap<>());
        }
        for (int[] flight : flights) {
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        q.offer(new int[]{src, 0, -1}); // city, total costs, stops
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == dst) {
                return cur[1];
            }
            Map<Integer, Integer> nexts = map.get(cur[0]);
            for (int next : nexts.keySet()) {
                if (cur[2] < K) {
                    q.offer(new int[]{next, cur[1] + nexts.get(next), cur[2] + 1});
                }
            }
        }
        return -1;
    }
}
