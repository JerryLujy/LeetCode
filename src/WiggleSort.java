/**
 * <h1>280. Wiggle Sort</h1>
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * <p>
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 *
 * @author Jerry
 * @since 2/10/17
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i - 1] > nums[i]) {
                swap(nums, i - 1, i);
            }
        }
        for (int i = 2; i < nums.length; i += 2) {
            if (nums[i - 1] < nums[i]) {
                swap(nums, i - 1, i);
            }
        }
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
