/**
 * <h1>53. Maximum Subarray</h1>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * @author Jerry
 * @since 8/27/16
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int curMax = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            curMax = Math.max(0, curMax) + num;
            max = Math.max(max, curMax);
        }
        return max;
    }
}
