/**
 * <h1>416. Partition Equal Subset Sum</h1>
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note: Each of the array element will not exceed 100. The array size will not exceed 200.
 * <p>
 * Example 1: Input: [1, 5, 11, 5], Output: true. Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * <p>
 * Example 2: Input: [1, 2, 3, 5], Output: false. Explanation: The array cannot be partitioned into equal sum subsets.
 *
 * @author Jerry
 * @since 1/15/19
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j] || (j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]]);
            }
        }
        return dp[nums.length][sum];
    }
}
