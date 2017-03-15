import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>496. Next Greater Element I</h1>
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * <p>
 * Example 1: Input: nums1 = [4,1,2], nums2 = [1,3,4,2]. Output: [-1,3,-1].
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * <p>
 * Example 2: Input: nums1 = [2,4], nums2 = [1,2,3,4]. Output: [3,-1].
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * <p>
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 *
 * @author Jerry
 * @since 3/15/17
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] ans = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            ans[i] = map.getOrDefault(findNums[i], -1);
        }
        return ans;
    }
}
