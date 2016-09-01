import java.util.ArrayList;
import java.util.List;

/**
 * <h1>78. Subsets</h1>
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * For example, If nums = [1,2,3], a solution is:[[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[]]
 *
 * @author Jerry
 * @since 9/1/16
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (long map = 0; map < 1 << nums.length; map++) {
            getSubset(ans, nums, map);
        }
        return ans;
    }

    private void getSubset(List<List<Integer>> ans, int[] nums, long map) {
        List<Integer> set = new ArrayList<>();
        for (int num : nums) {
            if ((map & 1) == 1) {
                set.add(num);
            }
            map >>= 1;
        }
        ans.add(set);
    }
}
