/**
 * <h1>26. Remove Duplicates from Sorted Array</h1>
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * For example, Given input array nums = [1,1,2].
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 *
 * @author Jerry
 * @since 8/19/16
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int i = 0, j = 1;
        while (j < nums.length) {
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            if (j < nums.length) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
