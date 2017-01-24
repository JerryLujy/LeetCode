/**
 * <h1>152. Maximum Product Subarray</h1>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 *
 * @author Jerry
 * @since 1/23/17
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = max, result = max;
        for (int i = 1; i < nums.length; i++) {
            int tmpMax = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(tmpMax * nums[i], min * nums[i]));
            result = Math.max(result, max);
        }
        return result;
    }
}
