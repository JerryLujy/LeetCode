import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h1>947. Most Stones Removed with Same Row or Column</h1>
 * On a 2D plane, we place stones at some integer coordinate points. Each coordinate point may have at most one stone.
 * Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
 * What is the largest possible number of moves we can make?
 * <p>
 * Example 1: Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]], Output: 5
 * <p>
 * Example 2: Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]], Output: 3
 * <p>
 * Example 3: Input: stones = [[0,0]], Output: 0
 * <p>
 * Note:
 * 1 <= stones.length <= 1000
 * 0 <= stones[i][j] < 10000
 *
 * @author Jerry
 * @since 2/5/19
 */
public class MostStonesRemovedWithSameRowOrColumn {
    public int removeStones(int[][] stones) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < stones.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < stones.length - 1; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        int components = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            if (visited.add(i)) {
                components++;
                dfs(graph, visited, i);
            }
        }
        return stones.length - components;
    }

    private void dfs(List<List<Integer>> graph, Set<Integer> visited, int cur) {
        for (int next : graph.get(cur)) {
            if (visited.add(next)) {
                dfs(graph, visited, next);
            }
        }
    }
}
