import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * <h1>353. Design Snake Game</h1>
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.
 * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
 * You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.
 * Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.
 * When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
 * <p>
 * Example: Given width = 3, height = 2, and food = [[1,2],[0,1]]. Snake snake = new Snake(width, height, food);
 * Initially the snake appears at position (0,0) and the food at (1,2).
 * <pre>
 * |S| | |
 * | | |F|
 * </pre>
 * snake.move("R"); -> Returns 0
 * <pre>
 * | |S| |
 * | | |F|
 * </pre>
 * snake.move("D"); -> Returns 0
 * <pre>
 * | | | |
 * | |S|F|
 * </pre>
 * snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )
 * <pre>
 * | |F| |
 * | |S|S|
 * </pre>
 * snake.move("U"); -> Returns 1
 * <pre>
 * | |F|S|
 * | | |S|
 * </pre>
 * snake.move("L"); -> Returns 2 (Snake eats the second food)
 * <pre>
 * | |S|S|
 * | | |S|
 * </pre>
 * snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 *
 * @author Jerry
 * @since 2/27/17
 */
public class DesignSnakeGame {
    private int m, n, foodInd, score, head;
    private int[][] foods;
    private HashSet<Integer> snake;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public DesignSnakeGame(int width, int height, int[][] food) {
        n = width;
        m = height;
        foodInd = 0;
        score = 0;
        foods = food;
        snake = new LinkedHashSet<>();
        snake.add(0);
        head = 0;
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        int tail = snake.iterator().next();
        int row = head / n, col = head % n;
        switch (direction) {
            case "U":
                row -= 1;
                break;
            case "L":
                col -= 1;
                break;
            case "R":
                col += 1;
                break;
            case "D":
                row += 1;
                break;
            default:
                break;
        }
        head = row * n + col;
        if (row < 0 || row >= m || col < 0 || col >= n || (snake.contains(head) && head != tail)) {
            return -1;
        }
        if (foodInd < foods.length && row == foods[foodInd][0] && col == foods[foodInd][1]) {
            score++;
            foodInd++;
        } else {
            snake.remove(tail);
        }
        snake.add(head);
        return score;
    }
}
