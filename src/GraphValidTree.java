import java.util.*;

/**
 * <h1>261. Graph Valid Tree</h1>
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 * <p>
 * For example: Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * <p>
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * @author Jerry
 * @since 2/5/17
 */
public class GraphValidTree {
    public boolean validTreeBFS(int n, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        List<Set<Integer>> neighbors = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            neighbors.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (visited.contains(cur)) {
                return false;
            }
            visited.add(cur);
            for (Integer neighbor : neighbors.get(cur)) {
                neighbors.get(neighbor).remove(cur);
                queue.offer(neighbor);
            }
        }
        return visited.size() == n;
    }

    public boolean validTreeUF(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (uf.find(edge[0]) == uf.find(edge[1])) {
                return false;
            }
            uf.union(edge[0], edge[1]);
        }
        return uf.count() == 1;
    }

    private static class UnionFind {
        int[] father;
        int count;

        UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
            count = n;
        }

        int find(int x) {
            if (father[x] == x) {
                return x;
            }
            father[x] = find(father[x]);
            return father[x];
        }

        void union(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx != fy) {
                father[fx] = fy;
            }
            count--;
        }

        int count() {
            return count;
        }
    }
}
