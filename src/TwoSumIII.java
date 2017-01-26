import java.util.HashMap;
import java.util.Map;

/**
 * <h1>170. Two Sum III - Data structure design</h1>
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * <p>
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * <p>
 * For example, add(1); add(3); add(5); find(4) -> true; find(7) -> false
 *
 * @author Jerry
 * @since 1/25/17
 */
public class TwoSumIII {
    private Map<Integer, Integer> nums;

    /**
     * Initialize your data structure here.
     */
    public TwoSumIII() {
        nums = new HashMap<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        nums.merge(number, 1, Integer::sum);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int num : nums.keySet()) {
            int num2 = value - num;
            if (num == num2 && nums.get(num) > 1 || num != num2 && nums.containsKey(num2)) {
                return true;
            }
        }
        return false;
    }
}
