import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>40. Combination Sum II</h1>
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * <p>
 * Note: All numbers (including target) will be positive integers. The solution set must not contain duplicate combinations.
 * <p>
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, A solution set is:[[1, 7],[1, 2, 5],[2, 6],[1, 1, 6]]
 *
 * @author Jerry
 * @since 8/24/16
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);

        findCombination(ans, combination, candidates, 0, target);

        return ans;
    }

    private void findCombination(List<List<Integer>> ans, List<Integer> combination, int[] candidates, int from, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }
        int prev = -1;
        for (int i = from; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (candidates[i] == prev) {
                continue;
            }
            combination.add(candidates[i]);
            findCombination(ans, combination, candidates, i + 1, target - candidates[i]);
            combination.remove(combination.size() - 1);
            prev = candidates[i];
        }
    }
}
