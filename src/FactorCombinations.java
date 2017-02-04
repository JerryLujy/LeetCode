import java.util.ArrayList;
import java.util.List;

/**
 * <h1>254. Factor Combinations</h1>
 * Numbers can be regarded as product of its factors. For example, 8 = 2 x 2 x 2; = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * <p>
 * Note: You may assume that n is always positive. Factors should be greater than 1 and less than n.
 * <p>
 * Examples: input: 1, output: []
 * <p>
 * input: 37, output: []
 * <p>
 * input: 12, output: [[2, 6],[2, 2, 3],[3, 4]]
 * <p>
 * input: 32, output: [[2, 16],[2, 2, 8],[2, 2, 2, 4],[2, 2, 2, 2, 2],[2, 4, 4],[4, 8]]
 *
 * @author Jerry
 * @since 2/4/17
 */
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> factors = new ArrayList<>();
        if (n < 4) {
            return ans;
        }
        getFactors(ans, factors, n);
        return ans;
    }

    private void getFactors(List<List<Integer>> ans, List<Integer> factors, int n) {
        if (n == 1) {
            ans.add(new ArrayList<>(factors));
        }
        int start = factors.size() > 0 ? factors.get(factors.size() - 1) : 2;
        for (int i = start; i <= (int) Math.sqrt(n); i++) {
            if (n % i != 0) {
                continue;
            }
            factors.add(i);
            getFactors(ans, factors, n / i);
            factors.remove(factors.size() - 1);
        }
        if (factors.size() > 0) {
            factors.add(n);
            ans.add(new ArrayList<>(factors));
            factors.remove(factors.size() - 1);
        }
    }
}
