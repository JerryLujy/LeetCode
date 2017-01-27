/**
 * <h1>198. House Robber</h1>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * @author Jerry
 * @since 1/26/17
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int prev = 0, curr = 0;
        for (int num : nums) {
            int tmp = curr;
            curr = Math.max(curr, prev + num);
            prev = tmp;
        }
        return curr;
    }
}
