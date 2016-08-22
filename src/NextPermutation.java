/**
 * <h1>31. Next Permutation</h1>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * <p>
 * Here are some examples.
 * <p>
 * 1,2,3 -> 1,3,2
 * <p>
 * 3,2,1 -> 1,2,3
 * <p>
 * 1,1,5 -> 1,5,1
 *
 * @author Jerry
 * @since 8/22/16
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        for (; i >= 0 && nums[i + 1] <= nums[i]; i--) ;

        // At largest permutation, return its smallest order
        if (i == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Find the smallest number larger than nums[i] after i
        int target = nums.length - 1;
        for (; target > i && nums[target] <= nums[i]; target--) ;

        swap(nums, i, target);
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}
