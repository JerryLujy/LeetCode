import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>47. Permutations II</h1>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example, [1,1,2] have the following unique permutations: [[1,1,2],[1,2,1],[2,1,1]]
 *
 * @author Jerry
 * @since 8/26/16
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        getPermutations(ans, perm, nums, used);
        return ans;
    }

    private void getPermutations(List<List<Integer>> ans, List<Integer> perm, int[] nums, boolean[] used) {
        if (perm.size() == nums.length) {
            ans.add(new ArrayList<>(perm));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i] && (i == 0 || used[i - 1] || nums[i] != nums[i - 1])) {
                used[i] = true;
                perm.add(nums[i]);
                getPermutations(ans, perm, nums, used);
                perm.remove(perm.size() - 1);
                used[i] = false;
            }
        }
    }
}
