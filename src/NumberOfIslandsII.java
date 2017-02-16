import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>305. Number of Islands II</h1>
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns
 * the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example: Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 * We return the result as an array: [1, 1, 2, 3]
 *
 * @author Jerry
 * @since 2/15/17
 */
public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        UnionFind uf = new UnionFind();
        for (int[] pos : positions) {
            int x = pos[0], y = pos[1], curr = x * n + y;
            uf.add(curr);
            if (x > 0 && uf.contains((x - 1) * n + y)) {
                uf.union(curr, (x - 1) * n + y);
            }
            if (x < m - 1 && uf.contains((x + 1) * n + y)) {
                uf.union(curr, (x + 1) * n + y);
            }
            if (y > 0 && uf.contains(x * n + y - 1)) {
                uf.union(curr, x * n + y - 1);
            }
            if (y < n - 1 && uf.contains(x * n + y + 1)) {
                uf.union(curr, x * n + y + 1);
            }
            ans.add(uf.count);
        }
        return ans;
    }

    private static class UnionFind {
        Map<Integer, Integer> fathers;
        int count;

        UnionFind() {
            fathers = new HashMap<>();
            count = 0;
        }

        void add(int x) {
            if (!fathers.containsKey(x)) {
                fathers.put(x, x);
                count++;
            }
        }

        boolean contains(int x) {
            return fathers.containsKey(x);
        }

        int find(int x) {
            int father = fathers.get(x);
            if (father == x) {
                return x;
            }
            fathers.put(x, find(father));
            return fathers.get(x);
        }

        void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                count--;
                fathers.put(fx, fy);
            }
        }
    }
}
