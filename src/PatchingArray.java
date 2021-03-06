/**
 * <h1>330. Patching Array</h1>
 * Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that
 * any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.
 * <p>
 * Example 1: nums = [1, 3], n = 6, Return 1.
 * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
 * Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
 * Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6]. So we only need 1 patch.
 * <p>
 * Example 2: nums = [1, 5, 10], n = 20, Return 2. The two patches can be [2, 4].
 * <p>
 * Example 3: nums = [1, 2, 2], n = 5, Return 0.
 *
 * @author Jerry
 * @since 2/25/17
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long range = 0; // Initially range covered is none - [1,0]
        int i = 0;
        int patches = 0;
        while (range < n) {
            if (i < nums.length && nums[i] <= range + 1) {
                range += nums[i++];
            } else {
                range += range + 1; // Patch the number range + 1;
                patches++;
            }
        }
        return patches;
    }
}
