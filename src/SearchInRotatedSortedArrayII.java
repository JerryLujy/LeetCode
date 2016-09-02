/**
 * <h1>81. Search in Rotated Sorted Array II</h1>
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 *
 * @author Jerry
 * @since 9/1/16
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        // Doing linear search because worst-case complexity is O(n)
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
