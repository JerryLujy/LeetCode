import java.util.HashMap;
import java.util.Map;

/**
 * <h1>1. Two Sum</h1>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution.
 *
 * @author Jerry
 * @since 5/23/16
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(target - nums[i])) {
                return new int[]{i, indexMap.get(target - nums[i])};
            }
            indexMap.put(nums[i], i);
        }
        throw new RuntimeException("No combination could be found");
    }
}
