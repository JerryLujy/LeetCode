import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>42. Trapping Rain Water</h1>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 * @author Jerry
 * @since 8/24/16
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int amount = 0;
        int waterlevel = Math.min(height[l], height[r]);
        while (l <= r) {
            int curlevel = Math.min(height[l], height[r]);
            if (waterlevel > curlevel) {
                amount += waterlevel - curlevel;
            } else {
                waterlevel = curlevel;
            }
            if (height[l] <= height[r]) {//Start pouring from left
                l++;
            } else {
                r--;
            }
        }
        return amount;
    }

    public int trap2(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int prevHeight = height[stack.pop()];
                if (!stack.isEmpty()) {
                    int waterLevel = Math.min(height[stack.peek()], height[i]);
                    ans += (waterLevel - prevHeight) * (i - stack.peek() - 1); // height * width
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
