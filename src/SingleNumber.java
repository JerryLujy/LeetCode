/**
 * <h1>136. Single Number</h1>
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * @author Jerry
 * @since 1/20/17
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i : nums) {
            num ^= i;
        }
        return num;
    }
}
