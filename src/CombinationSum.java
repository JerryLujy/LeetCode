import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>39. Combination Sum</h1>
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note: All numbers (including target) will be positive integers. The solution set must not contain duplicate combinations.
 * <p>
 * For example, given candidate set [2, 3, 6, 7] and target 7, A solution set is: [[7],[2, 2, 3]]
 *
 * @author Jerry
 * @since 8/24/16
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);

        findCombination(ans, combination, candidates, 0, target);

        return ans;
    }

    private void findCombination(List<List<Integer>> ans, List<Integer> combination, int[] candidates, int ind, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }
        for (int i = ind; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            combination.add(candidates[i]);
            findCombination(ans, combination, candidates, i, target - candidates[i]);
            combination.remove(combination.size() - 1);
        }
    }
}
