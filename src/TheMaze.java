import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <h1>490. The Maze</h1>
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down,
 * left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space.
 * You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 * <p>
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
 * <p>
 * Example 2:
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
    private static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(start[0], start[1]));
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == destination[0] && cur.y == destination[1]) {
                return true;
            }
            visited[cur.x][cur.y] = true;
            for (int i = 0; i < 4; i++) {
                int x = cur.x, y = cur.y;
                while (x + dx[i] >= 0 && x + dx[i] < m && y + dy[i] >= 0 && y + dy[i] < n &&
                        maze[x + dx[i]][y + dy[i]] == 0) {
                    x += dx[i];
                    y += dy[i];
                }
                if (!visited[x][y]) {
                    q.offer(new Point(x, y));
                }
            }
        }
        return false;
    }

    private static class Point {
        int x, y;
        Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
}
