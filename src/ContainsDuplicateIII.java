import java.util.TreeSet;

/**
 * <h1>220. Contains Duplicate III</h1>
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that
 * the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * @author Jerry
 * @since 1/30/17
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> seen = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            Long floor = seen.floor(num + t);
            Long ceiling = seen.ceiling(num - t);
            if (floor != null && floor >= num || ceiling != null && ceiling <= num) {
                return true;
            }
            seen.add(num);
            if (i >= k) {
                seen.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
