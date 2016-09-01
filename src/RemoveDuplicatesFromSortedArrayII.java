/**
 * <h1>80. Remove Duplicates from Sorted Array II</h1>
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 * For example, Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 *
 * @author Jerry
 * @since 9/1/16
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        int l = 1;
        for (int r = 2; r < nums.length; r++) {
            if (nums[r] != nums[l] || nums[r] != nums[l - 1]) {
                nums[++l] = nums[r];
            }
        }
        return l + 1;
    }
}
