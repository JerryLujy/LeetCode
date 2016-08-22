/**
 * <h1>32. Longest Valid Parentheses</h1>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 * <p>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 *
 * @author Jerry
 * @since 8/22/16
 */
public class LongestValidParentheses {
    /**
     * dp[i] = the longest valid substring length that ends at i
     * 0                                                                          , if s[i]='('
     * 2 + dp[i-2]                                              , if s[i-1]='(' -
     * 2 + dp[i-1] + dp[i-2-dp[i-1]] , if s[i-1-dp[i-1]]='('  -                  |- if s[i]=')'
     * .                                                       |- if s[i-1]=')' -
     * 0                             , otherwise              -
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2 + ((i - 2 >= 0) ? dp[i - 2] : 0);
                } else if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    dp[i] = 2 + dp[i - 1] + ((i - 2 - dp[i - 1] >= 0) ? dp[i - 2 - dp[i - 1]] : 0);
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}
