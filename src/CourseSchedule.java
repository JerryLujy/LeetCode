import java.util.ArrayList;
import java.util.List;

/**
 * <h1>207. Course Schedule</h1>
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * For example: 2, [[1,0]], There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * 2, [[1,0],[0,1]], There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 * @author Jerry
 * @since 1/28/17
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] mark = new int[numCourses];// 0 unmarked; 1 temporary marked; 2 marked
        List<List<Integer>> edges = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            edges.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(mark, i, edges)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[] mark, int i, List<List<Integer>> edges) {
        if (mark[i] == 1) {// Cyclic graph
            return false;
        } else if (mark[i] == 0) {
            mark[i] = 1;
            for (Integer next : edges.get(i)) {
                if (!dfs(mark, next, edges)) {
                    return false;
                }
            }
            mark[i] = 2;
        }
        return true;
    }
}
