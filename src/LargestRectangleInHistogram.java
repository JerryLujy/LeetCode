import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>84. Largest Rectangle in Histogram</h1>
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * For example, given heights = [2,1,5,6,2,3], return 10.
 *
 * @author Jerry
 * @since 9/3/16
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= heights.length; i++) {
            int curHeight = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peekLast()] > curHeight) {
                int height = heights[stack.pollLast()];
                int width = stack.isEmpty() ? i : i - stack.peekLast() - 1;
                area = Math.max(area, height * width);
            }
            stack.offerLast(i);
        }
        return area;
    }
}
