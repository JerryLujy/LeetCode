/**
 * <h1>323. Number of Connected Components in an Undirected Graph</h1>
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 * <p>
 * Example 1: Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * <pre>
 * 0          3
 * |          |
 * 1 --- 2    4
 * </pre>
 * Example 2: Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 * <pre>
 * 0           4
 * |           |
 * 1 --- 2 --- 3
 * </pre>
 * Note:
 * You can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * @author Jerry
 * @since 2/24/17
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count();
    }

    private static class UnionFind {
        private int count;
        private int[] father;

        UnionFind(int n) {
            count = n;
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        int find(int x) {
            if (father[x] == x) {
                return x;
            }
            return father[x] = find(father[x]);
        }

        void union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx != fy) {
                father[fx] = fy;
                count--;
            }
        }

        int count() {
            return count;
        }
    }
}
