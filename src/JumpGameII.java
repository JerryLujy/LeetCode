/**
 * <h1>45. Jump Game II</h1>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * For example: Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *
 * @author Jerry
 * @since 8/26/16
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int l = 0;
        int r = 0;
        int farthest = 0;
        int jumpCount = 0;
        while (r < nums.length - 1) {
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            jumpCount++;
        }
        return jumpCount;
    }
}
