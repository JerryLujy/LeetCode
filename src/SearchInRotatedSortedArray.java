/**
 * <h1>33. Search in Rotated Sorted Array</h1>
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 * @author Jerry
 * @since 8/23/16
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        int rot = l;
        for (l = 0, r = nums.length - 1; l <= r; ) {
            int m = (l + r) >>> 1;
            int mReal = (m + rot) % nums.length;
            if (nums[mReal] == target) {
                return mReal;
            } else if (nums[mReal] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        for (int l = 0, r = nums.length - 1; l <= r; ) {
            int m = (l + r) >>> 1;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] >= nums[l]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target <= nums[r] && target > nums[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
