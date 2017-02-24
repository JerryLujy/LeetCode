import java.util.HashMap;
import java.util.Map;

/**
 * <h1>325. Maximum Size Subarray Sum Equals k</h1>
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
 * If there isn't one, return 0 instead.
 * <p>
 * Note: The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 * <p>
 * Example 1: Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * <p>
 * Example 2: Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 *
 * @author Jerry
 * @since 2/24/17
 */
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.putIfAbsent(sum, i);
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
        }
        return maxLen;
    }
}
