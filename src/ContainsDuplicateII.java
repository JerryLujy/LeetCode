import java.util.HashMap;
import java.util.Map;

/**
 * <h1>219. Contains Duplicate II</h1>
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * @author Jerry
 * @since 1/30/17
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (positions.containsKey(nums[i]) && i - positions.get(nums[i]) <= k) {
                return true;
            }
            positions.put(nums[i], i);
        }
        return false;
    }
}
