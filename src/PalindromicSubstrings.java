/**
 * <h1>647. Palindromic Substrings</h1>
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * <p>
 * Example 1: Input: "abc", Output: 3, Explanation: Three palindromic strings: "a", "b", "c".
 * <p>
 * Example 2: Input: "aaa", Output: 6, Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * Note: The input string length won't exceed 1000.
 *
 * @author Jerry
 * @since 1/24/19
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int ans = s.length();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i < s.length() - 1 && (dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1))) {
                ans++;
            }
        }
        for (int k = 2; k < s.length(); k++) {
            for (int i = 0; i < s.length() - k; i++) {
                if (dp[i][i + k] = dp[i + 1][i + k - 1] && s.charAt(i) == s.charAt(i + k)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
