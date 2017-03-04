/**
 * <h1>360. Sort Transformed Array</h1>
 * Given a sorted array of integers nums and integer values a, b and c.
 * Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.
 * The returned array must be in sorted order. Expected time complexity: O(n)
 * <p>
 * Example: nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5, Result: [3, 9, 15, 33]
 * <p>
 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5, Result: [-23, -5, 1, 7]
 *
 * @author Jerry
 * @since 3/3/17
 */
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        boolean isPositive = a > 0;
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = (a * nums[i] * nums[i] + b * nums[i] + c) * (isPositive ? -1 : 1);
        }

        int[] ans = new int[nums.length];
        for (int l = 0, r = nums.length - 1, i = 0; l <= r; i++) {
            if (tmp[l] < tmp[r]) {
                ans[i] = tmp[l++];
            } else {
                ans[i] = tmp[r--];
            }
        }
        if (isPositive) {
            for (int l = 0, r = ans.length - 1; l <= r; l++, r--) {
                int temp = ans[l];
                ans[l] = -ans[r];
                ans[r] = -temp;
            }
        }
        return ans;
    }
}
