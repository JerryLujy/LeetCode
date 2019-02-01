import java.util.HashSet;
import java.util.Set;

/**
 * <h1>489. Robot Room Cleaner</h1>
 * Given a robot cleaner in a room modeled as a grid. Each cell in the grid can be empty or blocked.
 * The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
 * When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
 * Design an algorithm to clean the entire room using only the 4 given APIs.
 * <p>
 * Example:
 * Input:
 * room = [
 * [1,1,1,1,1,0,1,1],
 * [1,1,1,1,1,0,1,1],
 * [1,0,1,1,1,1,1,1],
 * [0,0,0,1,0,0,0,0],
 * [1,1,1,1,1,1,1,1]
 * ], row = 1, col = 3
 * <p>
 * Explanation:
 * All grids in the room are marked by either 0 or 1.
 * 0 means the cell is blocked, while 1 means the cell is accessible.
 * The robot initially starts at the position of row=1, col=3.
 * From the top left corner, its position is one row below and three columns right.
 * <p>
 * Notes:
 * The input is only given to initialize the room and the robot's position internally.
 * You must solve this problem "blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
 * The robot's initial position will always be in an accessible cell.
 * The initial direction of the robot will be facing up.
 * All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
 * Assume all four edges of the grid are all surrounded by wall.
 *
 * @author Jerry
 * @since 1/31/19
 */
public class RobotRoomCleaner {
    private int[] dx = {-1, 0, 1, 0}; // up, right, down, left
    private int[] dy = {0, 1, 0, -1};

    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0, new HashSet<>());
    }

    private void dfs(Robot robot, int x, int y, int dir, Set<String> visited) {
        visited.add(x + "," + y);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int nextDir = (dir + i) % 4;
            int xx = x + dx[nextDir], yy = y + dy[nextDir];
            if (!visited.contains(xx + "," + yy) && robot.move()) {
                dfs(robot, xx, yy, nextDir, visited);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }

    // This is the robot's control interface.
    // You should not implement it, or speculate about its implementation
    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        boolean move();
        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();
        void turnRight();
        // Clean the current cell.
        void clean();
    }
}
