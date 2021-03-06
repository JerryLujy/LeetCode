/**
 * <h1>72. Edit Distance</h1>
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * <p>
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 *
 * @author Jerry
 * @since 8/31/16
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;// Add or delete current char
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
