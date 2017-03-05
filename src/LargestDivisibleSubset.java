import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>368. Largest Divisible Subset</h1>
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * <p>
 * Example 1: nums: [1,2,3], Result: [1,2] (of course, [1,3] will also be ok)
 * <p>
 * Example 2: nums: [1,2,4,8], Result: [1,2,4,8]
 *
 * @author Jerry
 * @since 3/4/17
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1, maxInd = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) { // i-th number can be added to the set of j-th number
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    if (dp[i] > max) {
                        max = dp[i];
                        maxInd = i;
                    }
                }
            }
        }
        int maxVal = nums[maxInd];
        for (int i = maxInd; i >= 0; i--) {
            if (maxVal % nums[i] == 0 && dp[i] == max) {
                ans.add(nums[i]);
                max--;
            }
        }
        return ans;
    }
}
