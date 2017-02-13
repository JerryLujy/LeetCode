/**
 * <h1>516. Longest Palindromic Subsequence</h1>
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1: Input: "bbbab", Output: 4, One possible longest palindromic subsequence is "bbbb".
 * <p>
 * Example 2: Input: "cbbd", Output: 2, One possible longest palindromic subsequence is "bb".
 *
 * @author Jerry
 * @since 2/12/17
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        int ans = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                if (s.charAt(j) == s.charAt(j + i)) {
                    dp[j][j + i] = 2 + dp[j + 1][j + i - 1];
                } else {
                    dp[j][j + i] = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]);
                }
                ans = Math.max(ans, dp[j][j + i]);
            }
        }
        return ans;
    }
}
