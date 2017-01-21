/**
 * <h1>137. Single Number II</h1>
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * <p>
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * @author Jerry
 * @since 1/20/17
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
            }
            single |= (sum % 3) << i;
        }
        return single;
    }
}
