import java.util.ArrayList;
import java.util.List;

/**
 * <h1>77. Combinations</h1>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example, If n = 4 and k = 2, a solution is: [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]
 *
 * @author Jerry
 * @since 9/1/16
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        nextCombination(ans, comb, n, k);
        return ans;
    }

    private void nextCombination(List<List<Integer>> ans, List<Integer> comb, int n, int k) {
        if (comb.size() == k) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        int lastNum = comb.size() > 0 ? comb.get(comb.size() - 1) : 0;
        if (n - lastNum < k - comb.size()) {
            return;
        }
        for (int i = lastNum + 1; i <= n; i++) {
            comb.add(i);
            nextCombination(ans, comb, n, k);
            comb.remove(comb.size() - 1);
        }
    }
}
