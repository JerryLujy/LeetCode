import java.util.Random;

/**
 * <h1>398. Random Pick Index</h1>
 * Given an array of integers with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 * <p>
 * Note: The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * <p>
 * Example: int[] nums = new int[] {1,2,3,3,3};
 * <p>
 * pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * <p>
 * pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 *
 * @author Jerry
 * @since 3/6/17
 */
public class RandomPickIndex {
    private int[] nums;
    private Random random;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int ans = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && random.nextInt(++count) == 0) {
                ans = i;
            }
        }
        return ans;
    }
}
