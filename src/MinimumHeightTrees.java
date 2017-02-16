import java.util.*;

/**
 * <h1>310. Minimum Height Trees</h1>
 * For a undirected graph with tree characteristics, we can choose any node as the root.
 * The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * <p>
 * The graph contains n nodes which are labeled from 0 to n - 1.
 * You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * <p>
 * You can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * <p>
 * Example 1: Given n = 4, edges = [[1, 0], [1, 2], [1, 3]], return [1]
 * <pre>
 *   0
 *   |
 *   1
 *  / \
 * 2   3
 * </pre>
 * Example 2: Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]],  return [3, 4]
 * <pre>
 * 0  1  2
 *  \ | /
 *    3
 *    |
 *    4
 *    |
 *    5
 * </pre>
 *
 * @author Jerry
 * @since 2/16/17
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> neighbors = buildGraph(n, edges);
        Set<Integer> leaves = new HashSet<>();
        for (Integer i : neighbors.keySet()) {
            if (neighbors.get(i).size() < 2) {
                leaves.add(i);
            }
        }
        while (n > 2) { // At most 2 MHTs
            n -= leaves.size();
            Set<Integer> newLeaves = new HashSet<>();
            for (Integer leaf : leaves) {
                Integer next = neighbors.get(leaf).iterator().next();
                neighbors.get(next).remove(leaf);
                if (neighbors.get(next).size() == 1) {
                    newLeaves.add(next);
                }
            }
            leaves = newLeaves;
        }
        return new ArrayList<>(leaves);
    }

    private Map<Integer, Set<Integer>> buildGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return map;
    }
}
