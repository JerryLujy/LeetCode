import java.util.Arrays;

/**
 * <h1>473. Matchsticks to Square</h1>
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has,
 * please find out a way you can make one square by using up all those matchsticks.
 * You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
 * <p>
 * Your input will be several matchsticks the girl has, represented with their stick length.
 * Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
 * <p>
 * Example 1: Input: [1,1,2,2,2], Output: true.
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 * <p>
 * Example 2: Input: [3,3,3,3,4], Output: false.
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * <p>
 * Note:
 * The length sum of the given matchsticks is in the range of 0 to 10^9.
 * The length of the given matchstick array will not exceed 15.
 *
 * @author Jerry
 * @since 2/22/17
 */
public class MatchsticksToSquare {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum == 0 || sum % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        int[] remains = new int[4];
        Arrays.fill(remains, sum / 4);
        return makesquare(nums, nums.length - 1, remains);
    }

    private boolean makesquare(int[] nums, int ind, int[] remains) {
        if (ind == -1) {
            return remains[0] == 0 && remains[1] == 0 && remains[2] == 0 && remains[3] == 0;
        }
        for (int i = 0; i < 4; i++) {
            if (remains[i] >= nums[ind]) {
                remains[i] -= nums[ind];
                if (makesquare(nums, ind - 1, remains)) {
                    return true;
                }
                remains[i] += nums[ind];
            }
        }
        return false;
    }
}
