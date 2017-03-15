import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>503. Next Greater Element II</h1>
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element.
 * The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
 * which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 * <p>
 * Example 1: Input: [1,2,1], Output: [2,-1,2]
 * <p>
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 *
 * @author Jerry
 * @since 3/15/17
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length * 2; i++) {
            int num = nums[i % nums.length];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                ans[stack.pop()] = num;
            }
            if (i < nums.length) {
                stack.push(i);
            }
        }
        for (int ind : stack) {
            ans[ind] = -1;
        }
        return ans;
    }
}
