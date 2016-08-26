import java.util.ArrayList;
import java.util.List;

/**
 * <h1>46. Permutations</h1>
 * Given a collection of distinct numbers, return all possible permutations.
 * For example, [1,2,3] have the following permutations: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * @author Jerry
 * @since 8/26/16
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        getPermutations(ans, perm, nums);
        return ans;
    }

    private void getPermutations(List<List<Integer>> ans, List<Integer> perm, int[] nums) {
        if (perm.size() == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i : nums) {
            if (!perm.contains(i)) {
                perm.add(i);
                getPermutations(ans, perm, nums);
                perm.remove(perm.size() - 1);
            }
        }
    }
}
