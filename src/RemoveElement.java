/**
 * <h1>27. Remove Element</h1>
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example: Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * @author Jerry
 * @since 8/19/16
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}
