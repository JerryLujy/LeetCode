/**
 * <h1>35. Search Insert Position</h1>
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * <p>
 * Here are few examples.
 * <p>
 * [1,3,5,6], 5 -> 2
 * <p>
 * [1,3,5,6], 2 -> 1
 * <p>
 * [1,3,5,6], 7 -> 4
 * <p>
 * [1,3,5,6], 0 -> 0
 *
 * @author Jerry
 * @since 8/23/16
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
