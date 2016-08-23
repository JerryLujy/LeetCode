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
        if (nums == null || nums.length < 1) {
            return -1;
        }
        if (nums[0] < nums[nums.length - 1]) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        int largestInd = findLargestElemInd(nums);
        if (target >= nums[0]) {
            return binarySearch(nums, 0, largestInd, target);
        } else {
            return binarySearch(nums, largestInd + 1, nums.length - 1, target);
        }
    }

    private int findLargestElemInd(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (true) {
            if (l > r) throw new RuntimeException("Should not happen");
            m = l + (r - l) / 2;
            if (nums[m] > nums[m + 1]) {
                return m;
            }
            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int l = start;
        int r = end;
        int m;
        while (true) {
            if (l > r) {
                return -1;
            }
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
    }
}
