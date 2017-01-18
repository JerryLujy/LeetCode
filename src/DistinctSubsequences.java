/**
 * <h1>115. Distinct Subsequences</h1>
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting
 * some (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p>
 * Here is an example: S = "rabbbit", T = "rabbit", Return 3.
 *
 * @author Jerry
 * @since 1/17/17
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return 0;
        }
        int[][] dp = new int[t.length()][s.length()];
        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            dp[0][i] = dp[0][i - 1] + (s.charAt(i) == t.charAt(0) ? 1 : 0);
        }
        for (int i = 1; i < t.length(); i++) {
            dp[i][i] = (dp[i - 1][i - 1] == 1 && s.charAt(i) == t.charAt(i)) ? 1 : 0;
            for (int j = i; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length() - 1][s.length() - 1];
    }
}
