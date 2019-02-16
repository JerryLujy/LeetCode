/**
 * <h1>75. Sort Colors</h1>
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * @author Jerry
 * @since 8/31/16
 */
public class SortColors {
    public void sortColors(int[] nums) {
        // 3-way partition
        int l = 0, r = nums.length - 1, cur = 0;
        while (cur <= r) {
            if (nums[cur] == 1) {
                cur++;
            } else if (nums[cur] == 0) {
                swap(nums, l++, cur++);
            } else {
                swap(nums, cur, r--);
            }
        }
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
