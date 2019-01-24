/**
 * <h1>562. Longest Line of Consecutive One in Matrix</h1>
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.
 * <p>
 * Example:
 * Input:
 * [[0,1,1,0],
 *  [0,1,1,0],
 *  [0,0,0,1]]
 * Output: 3
 * Hint: The number of elements in the given matrix will not exceed 10,000.
 *
 * @author Jerry
 * @since 1/23/19
 */
public class LongestLineOfConsecutiveOneInMatrix {
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        int m = M.length, n = M[0].length, ans = 0;
        int[][][] dp = new int[m][n][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 0) {
                    continue;
                }
                dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = dp[i][j][3] = 1;
                dp[i][j][0] += j > 0 ? dp[i][j - 1][0] : 0;
                ans = Math.max(ans, dp[i][j][0]);
                dp[i][j][1] += i > 0 ? dp[i - 1][j][1] : 0;
                ans = Math.max(ans, dp[i][j][1]);
                dp[i][j][2] += i > 0 && j > 0 ? dp[i - 1][j - 1][2] : 0;
                ans = Math.max(ans, dp[i][j][2]);
                dp[i][j][3] += i > 0 && j < n - 1 ? dp[i - 1][j + 1][3] : 0;
                ans = Math.max(ans, dp[i][j][3]);
            }
        }
        return ans;
    }
}
