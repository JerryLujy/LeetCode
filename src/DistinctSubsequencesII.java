import java.util.HashMap;
import java.util.Map;

/**
 * <h1>940. Distinct Subsequences II</h1>
 * Given a string S, count the number of distinct, non-empty subsequences of S .
 * Since the result may be large, return the answer modulo 10^9 + 7.
 * <p>
 * Example 1: Input: "abc", Output: 7. Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
 * <p>
 * Example 2: Input: "aba", Output: 6. Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba", "aa" and "aba".
 * <p>
 * Example 3: Input: "aaa", Output: 3. Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 * <p>
 * Note:
 * S contains only lowercase letters.
 * 1 <= S.length <= 2000
 *
 * @author Jerry
 * @since 2/5/19
 */
public class DistinctSubsequencesII {
    private static final int MOD = 1_000_000_007;

    public int distinctSubseqII(String S) {
        int[] dp = new int[S.length() + 1];
        Map<Character, Integer> lastPos = new HashMap<>();
        dp[0] = 1;
        for (int i = 1; i <= S.length(); i++) {
            char c = S.charAt(i - 1);
            dp[i] = dp[i - 1] * 2 % MOD;
            if (lastPos.containsKey(c)) {
                dp[i] -= dp[lastPos.get(c)];
            }
            dp[i] %= MOD;
            lastPos.put(S.charAt(i - 1), i - 1);
        }
        return (dp[S.length()] - 1 + MOD) % MOD;
    }
}
