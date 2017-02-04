import java.util.Arrays;

/**
 * <h1>259. 3Sum Smaller</h1>
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * <p>
 * For example, given nums = [-2, 0, 1, 3], and target = 2. Return 2. Because there are two triplets which sums are less than 2:
 * [-2, 0, 1], [-2, 0, 3]
 *
 * @author Jerry
 * @since 2/4/17
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    ans += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}
