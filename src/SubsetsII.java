import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>90. Subsets II</h1>
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example, If nums = [1,2,2], a solution is: [[2],[1],[1,2,2],[2,2],[1,2],[]]
 *
 * @author Jerry
 * @since 9/6/16
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        Arrays.sort(nums);
        addElement(ans, set, nums, 0);
        return ans;
    }

    private void addElement(List<List<Integer>> ans, List<Integer> set, int[] nums, int ind) {
        ans.add(new ArrayList<>(set));
        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1]) {
                continue;
            }
            set.add(nums[i]);
            addElement(ans, set, nums, i + 1);
            set.remove(set.size() - 1);
        }
    }
}
