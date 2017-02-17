/**
 * <h1>312. Burst Balloons</h1>
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * <p>
 * Note:
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * <p>
 * Example: Given [3, 1, 5, 8], Return 167
 * <p>
 * nums  = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * <p>
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * @author Jerry
 * @since 2/16/17
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][nums.length];
        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i < nums.length - j; i++) {
                for (int k = i; k <= i + j; k++) {
                    int coins = nums[k]; // k is the last balloon to burst in [i,i+j]
                    coins *= (i > 0) ? nums[i - 1] : 1;
                    coins *= (i + j + 1 < nums.length) ? nums[i + j + 1] : 1;
                    coins += (k == i) ? 0 : dp[i][k - 1];
                    coins += (k == i + j) ? 0 : dp[k + 1][i + j];
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }
        return dp[0][nums.length - 1];
    }
}
