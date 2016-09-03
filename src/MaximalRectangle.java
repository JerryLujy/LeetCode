import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>85. Maximal Rectangle</h1>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * For example, given the following matrix:
 * <p>
 * 1 0 1 0 0
 * <p>
 * 1 0 1 1 1
 * <p>
 * 1 1 1 1 1
 * <p>
 * 1 0 0 1 0
 * <p>
 * Return 6.
 *
 * @author Jerry
 * @since 9/3/16
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[] hist = new int[matrix[0].length];
        int area = 0;
        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                hist[i] = row[i] == '1' ? hist[i] + 1 : 0;
            }
            area = Math.max(area, maximalRectangle(hist));
        }
        return area;
    }

    private int maximalRectangle(int[] hist) {
        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= hist.length; i++) {
            int curHeight = i == hist.length ? 0 : hist[i];
            while (!stack.isEmpty() && hist[stack.peekLast()] > curHeight) {
                int h = hist[stack.pollLast()];
                int w = stack.isEmpty() ? i : i - stack.peekLast() - 1;
                area = Math.max(area, h * w);
            }
            stack.offerLast(i);
        }
        return area;
    }
}
