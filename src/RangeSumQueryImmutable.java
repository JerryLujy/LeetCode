/**
 * <h1>303. Range Sum Query - Immutable</h1>
 * Given an integer array nums, find the sum of the elements between indices i and j (i <= j), inclusive.
 * <p>
 * Example: Given nums = [-2, 0, 3, -5, 2, -1]. sumRange(0, 2) -> 1. sumRange(2, 5) -> -1. sumRange(0, 5) -> -3
 * <p>
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 *
 * @author Jerry
 * @since 2/14/17
 */
public class RangeSumQueryImmutable {
    private int[] mem;

    public RangeSumQueryImmutable(int[] nums) {
        mem = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            mem[i + 1] = mem[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return mem[j + 1] - mem[i];
    }
}
