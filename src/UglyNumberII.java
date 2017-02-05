/**
 * <h1>264. Ugly Number II</h1>
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * <p>
 * Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 *
 * @author Jerry
 * @since 2/5/17
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int ind2 = 0, ind3 = 0, ind5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[ind2] * 2, Math.min(dp[ind3] * 3, dp[ind5] * 5));
            if (dp[i] == dp[ind2] * 2) {
                ind2++;
            }
            if (dp[i] == dp[ind3] * 3) {
                ind3++;
            }
            if (dp[i] == dp[ind5] * 5) {
                ind5++;
            }
        }
        return dp[n - 1];
    }
}
