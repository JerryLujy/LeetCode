import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>505. The Maze II</h1>
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down,
 * left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination.
 * The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included).
 * If the ball cannot stop at the destination, return -1.
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
 * Output: 12
 * Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
 *              The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
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
 * Output: -1
 * Explanation: There is no way for the ball to stop at the destination.
 *
 * @author Jerry
 * @since 1/20/19
 */
public class TheMazeII {
    private static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Point> q = new PriorityQueue<>(Comparator.comparingInt(p -> p.dist));
        q.offer(new Point(start[0], start[1], 0));
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == destination[0] && cur.y == destination[1]) {
                return cur.dist;
            }
            visited[cur.x][cur.y] = true;
            for (int i = 0; i < 4; i++) {
                int x = cur.x, y = cur.y, dist = cur.dist;
                while (x + dx[i] >= 0 && x + dx[i] < m && y + dy[i] >= 0 && y + dy[i] < n &&
                        maze[x + dx[i]][y + dy[i]] == 0) {
                    x += dx[i];
                    y += dy[i];
                    dist++;
                }
                if (!visited[x][y]) {
                    q.offer(new Point(x, y, dist));
                }
            }
        }
        return -1;
    }

    private static class Point {
        int x, y, dist;
        Point(int _x, int _y, int _dist) {
            x = _x;
            y = _y;
            dist = _dist;
        }
    }
}
