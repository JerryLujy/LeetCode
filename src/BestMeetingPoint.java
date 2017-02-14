import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h1>296. Best Meeting Point</h1>
 * A group of two or more people wants to meet and minimize the total travel distance.
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * <p>
 * For example, given three people living at (0,0), (0,4), and (2,2):
 * <pre>
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * </pre>
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 *
 * @author Jerry
 * @since 2/14/17
 */
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        List<Integer> xs = new ArrayList<>(), ys = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    xs.add(i);
                    ys.add(j);
                }
            }
        }
        return getMinDistance(xs) + getMinDistance(ys);
    }

    private int getMinDistance(List<Integer> list) {
        Collections.sort(list);
        int i = 0, j = list.size() - 1, ans = 0;
        while (i < j) {
            ans += list.get(j--) - list.get(i++);
        }
        return ans;
    }
}
