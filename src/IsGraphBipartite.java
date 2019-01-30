import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <h1>785. Is Graph Bipartite?</h1>
 * Given an undirected graph, return true if and only if it is bipartite.
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B
 * such that every edge in the graph has one node in A and another node in B.
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.
 * Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 * <p>
 * Example 1: Input: [[1,3], [0,2], [1,3], [0,2]]. Output: true
 * Explanation:
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * <p>
 * Example 2: Input: [[1,2,3], [0,2], [0,1,3], [0,2]]. Output: false
 * Explanation:
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 * <p>
 * Note:
 * graph will have length in range [1, 100].
 * graph[i] will contain integers in range [0, graph.length - 1].
 * graph[i] will not contain i or duplicate values.
 * The graph is undirected: if any element j is in graph[i], then i will be in graph[j].
 *
 * @author Jerry
 * @since 1/29/19
 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n]; // 0 unvisited, 1 and 2 are two colors
        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) {
                continue;
            }
            visited[i] = 1;
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int next : graph[cur]) {
                    if (visited[next] == 0) {
                        visited[next] = 3 - visited[cur];
                        q.offer(next);
                    } else if (visited[next] == visited[cur]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
