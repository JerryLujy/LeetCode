import java.util.HashMap;
import java.util.Map;

/**
 * <h1>904. Fruit Into Baskets</h1>
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 * You start at any tree of your choice, then repeatedly perform the following steps:
 * 1. Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * 2. Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2,
 * then back to step 1, then step 2, and so on until you stop.
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 * What is the total amount of fruit you can collect with this procedure?
 * <p>
 * Example 1: Input: [1,2,1], Output: 3. Explanation: We can collect [1,2,1].
 * <p>
 * Example 2: Input: [0,1,2,2], Output: 3. Explanation: We can collect [1,2,2]. If we started at the first tree, we would only collect [0, 1].
 * <p>
 * Example 3: Input: [1,2,3,2,2], Output: 4. Explanation: We can collect [2,3,2,2]. If we started at the first tree, we would only collect [1, 2].
 * <p>
 * Example 4: Input: [3,3,3,1,2,1,1,2,3,3,4], Output: 5. Explanation: We can collect [1,2,1,1,2]. If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 * <p>
 * Note:
 * 1 <= tree.length <= 40000
 * 0 <= tree[i] < tree.length
 *
 * @author Jerry
 * @since 2/3/19
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int ans = 0, l = 0, r = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < tree.length) {
            map.merge(tree[r], 1, Integer::sum);
            while (map.size() > 2) {
                if (map.get(tree[l]) == 1) {
                    map.remove(tree[l]);
                } else {
                    map.merge(tree[l], -1, Integer::sum);
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
