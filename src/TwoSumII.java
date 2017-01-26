/**
 * <h1>167. Two Sum II - Input array is sorted</h1>
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9; Output: index1=1, index2=2
 *
 * @author Jerry
 * @since 1/25/17
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }
}
