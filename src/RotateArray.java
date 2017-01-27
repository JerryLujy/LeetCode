/**
 * <h1>189. Rotate Array</h1>
 * Rotate an array of n elements to the right by k steps.
 * <p>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * <p>
 * Note: Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 * @author Jerry
 * @since 1/26/17
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) {
            return;
        }
        reverseBetween(nums, 0, nums.length - 1);
        reverseBetween(nums, 0, k - 1);
        reverseBetween(nums, k, nums.length - 1);
    }

    private void reverseBetween(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }
}
