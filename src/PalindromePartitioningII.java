/**
 * <h1>132. Palindrome Partitioning II</h1>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * For example, given s = "aab", Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 * @author Jerry
 * @since 1/20/17
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        int len = s.length();

        boolean[][] isPalindrome = new boolean[len][len];
        isPalindrome[0][0] = true;
        for (int i = 1; i < len; i++) {
            isPalindrome[i][i] = true;
            isPalindrome[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }
        for (int i = 2; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                isPalindrome[j][j + i] = isPalindrome[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
            }
        }

        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            if (!isPalindrome[0][i]) {
                dp[i] = 1 + dp[i - 1];
                for (int j = i - 1; j > 0; j--) {
                    if (isPalindrome[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[len - 1];
    }
}
