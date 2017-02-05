/**
 * <h1>268. Missing Number</h1>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * For example, Given nums = [0, 1, 3] return 2.
 *
 * @author Jerry
 * @since 2/5/17
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i] ^ i;
        }
        return xor ^ nums.length;
    }
}
