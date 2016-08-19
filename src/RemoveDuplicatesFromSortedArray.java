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
        int shift = 0;
        int cur = nums[0];
        int ind = 1;
        while (ind < nums.length) {
            if (nums[ind] == cur) {// Encounter duplicate number
                while (ind < nums.length && nums[ind] == cur) {// Find the next different number
                    ind++;
                    shift++;
                }
            }
            if (ind < nums.length) {
                // Shift the number to its position
                cur = nums[ind];
                nums[ind - shift] = cur;
            }
            ind++;
        }
        return nums.length - shift;
    }
}
