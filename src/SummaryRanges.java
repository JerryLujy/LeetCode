import java.util.ArrayList;
import java.util.List;

/**
 * <h1>228. Summary Ranges</h1>
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 * @author Jerry
 * @since 2/1/17
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int l = 0;
        while (l < nums.length) {
            int h = l;
            while (h + 1 < nums.length && nums[h] + 1 == nums[h + 1]) {
                h++;
            }
            if (l == h) {
                ans.add(String.valueOf(nums[l]));
            } else {
                ans.add(String.valueOf(nums[l]) + "->" + String.valueOf(nums[h]));
            }
            l = h + 1;
        }
        return ans;
    }
}
