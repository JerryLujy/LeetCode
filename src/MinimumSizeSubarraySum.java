/**
 * <h1>209. Minimum Size Subarray Sum</h1>
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous
 * subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.
 *
 * @author Jerry
 * @since 1/28/17
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, j = 0, sum = 0, size = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= s) {
                size = Math.min(size, j - i);
                sum -= nums[i++];
            }
        }
        return size == Integer.MAX_VALUE ? 0 : size;
    }
}
