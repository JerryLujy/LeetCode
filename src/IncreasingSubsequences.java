import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h1>491. Increasing Subsequences</h1>
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array,
 * and the length of an increasing subsequence should be at least 2 .
 * <p>
 * Example: Input: [4, 6, 7, 7], Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * <p>
 * Note:
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 *
 * @author Jerry
 * @since 3/23/17
 */
public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] nums, int ind, List<List<Integer>> ans, List<Integer> list) {
        if (list.size() > 1) {
            ans.add(new ArrayList<>(list));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = ind; i < nums.length; i++) {
            if (!used.contains(nums[i]) && (list.size() == 0 || nums[i] >= list.get(list.size() - 1))) {
                list.add(nums[i]);
                used.add(nums[i]);
                dfs(nums, i + 1, ans, list);
                used.remove(nums[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}
