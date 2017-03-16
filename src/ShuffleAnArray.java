import java.util.Arrays;
import java.util.Random;

/**
 * <h1>384. Shuffle an Array</h1>
 * Shuffle a set of numbers without duplicates.
 * <pre>
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 * </pre>
 *
 * @author Jerry
 * @since 3/6/17
 */
public class ShuffleAnArray {
    private int[] arr;
    private Random random;

    public ShuffleAnArray(int[] nums) {
        arr = nums;
        random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return arr;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] ans = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            int j = random.nextInt(arr.length);
            int tmp = ans[i];
            ans[i] = ans[j];
            ans[j] = tmp;
        }
        return ans;
    }
}
