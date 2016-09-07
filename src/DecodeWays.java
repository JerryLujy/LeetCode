/**
 * <h1>91. Decode Ways</h1>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example, given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12). The number of ways decoding "12" is 2.
 *
 * @author Jerry
 * @since 9/6/16
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            boolean validOneDigit = s.charAt(i - 1) != '0';
            int twoDigit = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            boolean validTwoDigit = twoDigit >= 10 && twoDigit <= 26;
            dp[i] = (validOneDigit ? dp[i - 1] : 0) + (validTwoDigit ? dp[i - 2] : 0);
        }
        return dp[s.length()];
    }
}
