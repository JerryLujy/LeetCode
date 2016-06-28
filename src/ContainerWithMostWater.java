/**
 * <h1>11. Container With Most Water</h1>
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * @author Jerry
 * @since 6/27/16
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int area = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            area = Math.max(area, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return area;
    }
}
