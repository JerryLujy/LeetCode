/**
 * <h1>55. Jump Game</h1>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * <p>
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 *
 * @author Jerry
 * @since 8/26/16
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int validPos = nums.length - 1;
        for (int i = validPos - 1; i >= 0; i--) {
            if (i + nums[i] >= validPos) {
                validPos = i;
            }
        }
        return validPos == 0;
    }
}
