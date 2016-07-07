import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>15. 3Sum</h1>
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4]
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author Jerry
 * @since 7/7/16
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return rst;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;// Avoid duplicate set
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> set = new ArrayList<>();
                    set.add(nums[i]);
                    set.add(nums[left]);
                    set.add(nums[right]);
                    rst.add(set);
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                } else if (sum > 0) {
                    right--;
                } else {//sum < 0
                    left++;
                }
            }
        }
        return rst;
    }
}
