/**
 * <h1>283. Move Zeroes</h1>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note: You must do this in-place without making a copy of the array. Minimize the total number of operations.
 *
 * @author Jerry
 * @since 2/8/17
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                nums[l++] = nums[r];
            }
            r++;
        }
        for (; l < nums.length; l++) {
            nums[l] = 0;
        }
    }
}
