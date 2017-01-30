import java.util.ArrayList;
import java.util.List;

/**
 * <h1>216. Combination Sum III</h1>
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * Example 1: Input: k = 3, n = 7, Output: [[1,2,4]]
 * <p>
 * Example 2: Input: k = 3, n = 9, Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @author Jerry
 * @since 1/29/17
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(ans, new ArrayList<>(), 0, k, n);
        return ans;
    }

    private void findCombinations(List<List<Integer>> ans, List<Integer> combination, int cur, int left, int sum) {
        if (left == 0) {
            if (sum == 0) {
                ans.add(new ArrayList<>(combination));
            }
            return;
        }
        for (int i = cur + 1; i <= Math.min(sum, 9); i++) {
            combination.add(i);
            findCombinations(ans, combination, i, left - 1, sum - i);
            combination.remove(combination.size() - 1);
        }
    }
}
