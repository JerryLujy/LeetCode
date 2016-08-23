/**
 * <h1>34. Search for a Range</h1>
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 *
 * @author Jerry
 * @since 8/23/16
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{searchFirstAppearance(nums, target), searchLastAppearance(nums, target)};
    }

    private int searchFirstAppearance(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (true) {
            if (l > r) {
                return -1;
            }
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                if (m == 0 || nums[m - 1] != target) {
                    return m;
                } else {
                    r = m - 1;
                }
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
    }

    private int searchLastAppearance(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (true) {
            if (l > r) {
                return -1;
            }
            m = l + (r - l) / 2;
            if (nums[m] == target) {
                if (m == nums.length - 1 || nums[m + 1] != target) {
                    return m;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
    }
}
