import java.util.ArrayList;
import java.util.List;

/**
 * <h1>163. Missing Ranges</h1>
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 * <p>
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 *
 * @author Jerry
 * @since 1/24/17
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        long start = (long) lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            long end = i == nums.length ? (long) upper + 1 : (long) nums[i];
            if (start <= end - 2) {
                ans.add(printRange(start + 1, end - 1));
            }
            start = end;
        }
        return ans;
    }

    private String printRange(long a, long b) {
        if (a == b) {
            return String.valueOf(a);
        } else {
            return String.format("%d->%d", a, b);
        }
    }
}
