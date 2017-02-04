import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h1>241. Different Ways to Add Parentheses</h1>
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways
 * to group numbers and operators. The valid operators are +, - and *.
 * <p>
 * Example 1: Input: "2-1-1". ((2-1)-1) = 0, (2-(1-1)) = 2, Output: [0, 2]
 * <p>
 * Example 2: Input: "2*3-4*5". (2*(3-(4*5))) = -34, ((2*3)-(4*5)) = -14, ((2*(3-4))*5) = -10, (2*((3-4)*5)) = -10,
 * (((2*3)-4)*5) = 10, Output: [-34, -14, -10, -10, 10]
 *
 * @author Jerry
 * @since 2/3/17
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        String[] numstrs = input.split("[\\+\\-\\*]");
        String[] opstrs = input.split("\\d+");
        int[] nums = new int[numstrs.length];
        for (int i = 0; i < numstrs.length; i++) {
            nums[i] = Integer.parseInt(numstrs[i]);
        }
        if (nums.length == 1) {
            return Collections.singletonList(nums[0]);
        }
        char[] ops = new char[opstrs.length - 1];// First of opstrs is always empty
        for (int i = 0; i < ops.length; i++) {
            ops[i] = opstrs[i + 1].charAt(0);
        }
        return findResults(ops, 0, ops.length, nums);
    }

    private List<Integer> findResults(char[] ops, int start, int end, int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (start == end) {
            ans.add(nums[start]);
            return ans;
        }
        for (int i = start; i < end; i++) {
            List<Integer> leftCombinations = findResults(ops, start, i, nums);
            List<Integer> rightCombinations = findResults(ops, i + 1, end, nums);
            for (int l : leftCombinations) {
                for (int r : rightCombinations) {
                    switch (ops[i]) {
                        case '+':
                            ans.add(l + r);
                            break;
                        case '-':
                            ans.add(l - r);
                            break;
                        case '*':
                            ans.add(l * r);
                            break;
                    }
                }
            }
        }
        return ans;
    }
}
