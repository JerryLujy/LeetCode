import java.util.HashMap;
import java.util.Map;

/**
 * <h1>560. Subarray Sum Equals K</h1>
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1: Input:nums = [1,1,1], k = 2. Output: 2
 * <p>
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 * @author Jerry
 * @since 1/23/19
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // One way to have sum 0 - empty subarray
        int sum = 0, ans = 0;
        for (int num : nums) {
            sum += num;
            ans += prefixSumCount.getOrDefault(sum - k, 0);
            prefixSumCount.merge(sum, 1, Integer::sum);
        }
        return ans;
    }
}
