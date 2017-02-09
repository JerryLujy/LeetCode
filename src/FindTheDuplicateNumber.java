/**
 * <h1>287. Find the Duplicate Number</h1>
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at
 * least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n^2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * @author Jerry
 * @since 2/8/17
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            int count = 0;
            for (int i : nums) {
                if (i < m + 1) {
                    count++;
                }
            }
            if (count < m + 1) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
