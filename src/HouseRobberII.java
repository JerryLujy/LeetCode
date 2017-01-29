/**
 * <h1>213. House Robber II</h1>
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will
 * not get too much attention. This time, all houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * @author Jerry
 * @since 1/28/17
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int prev = 0, curr = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int tmp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = tmp;
        }
        int ans = curr;
        prev = curr = 0;
        for (int i = 1; i < nums.length; i++) {
            int tmp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = tmp;
        }
        return Math.max(ans, curr);
    }
}
