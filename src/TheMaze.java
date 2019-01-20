import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * <h1>490. The Maze</h1>
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down,
 * left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space.
 * You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 *
 * Example 1:
 * Input 1: a maze represented by a 2D array
 *
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 *
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 * Output: true
 * Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
 *
 * Example 2:
 *
 * Input 1: a maze represented by a 2D array
 *
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 *
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 * Output: false
 * Explanation: There is no way for the ball to stop at the destination.
 *
 * @author Jerry
 * @since 1/20/19
 */
public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start[0] * n + start[1]);
        while (!q.isEmpty()) {
            int cur = q.poll();
            visited.add(cur);
            int x = cur / n, y = cur % n;
            if (x == destination[0] && y == destination[1]) {
                return true;
            }
            while (x + 1 < m && maze[x + 1][y] == 0) x++;
            if (!visited.contains(x * n + y)) q.offer(x * n + y);
            x = cur / n;
            while (x - 1 >= 0 && maze[x - 1][y] == 0) x--;
            if (!visited.contains(x * n + y)) q.offer(x * n + y);
            x = cur / n;
            while (y + 1 < n && maze[x][y + 1] == 0) y++;
            if (!visited.contains(x * n + y)) q.offer(x * n + y);
            y = cur % n;
            while (y - 1 >= 0 && maze[x][y - 1] == 0) y--;
            if (!visited.contains(x * n + y)) q.offer(x * n + y);
        }
        return false;
    }
}
