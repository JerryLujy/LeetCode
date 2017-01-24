/**
 * <h1>154. Find Minimum in Rotated Sorted Array II</h1>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element.
 * <p>
 * The array may contain duplicates.
 *
 * @author Jerry
 * @since 1/24/17
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]) {
                r = m;
            } else {
                r--;
            }
        }
        return nums[l];
    }
}
