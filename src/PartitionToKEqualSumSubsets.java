import java.util.Arrays;

/**
 * <h1>698. Partition to K Equal Sum Subsets</h1>
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 * <p>
 * Example 1: Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4. Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * <p>
 * Note:
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 *
 * @author Jerry
 * @since 1/26/19
 */
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int[] arr = new int[k];
        Arrays.fill(arr, sum / k);
        return dfs(nums, nums.length - 1, arr);
    }

    private boolean dfs(int[] nums, int ind, int[] arr) {
        if (ind < 0) {
            boolean valid = true;
            for (int bucket : arr) {
                valid &= bucket == 0;
            }
            return valid;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= nums[ind]) {
                arr[i] -= nums[ind];
                if (dfs(nums, ind - 1, arr)) {
                    return true;
                }
                arr[i] += nums[ind];
            }
        }
        return false;
    }
}
