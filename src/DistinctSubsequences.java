import java.util.Arrays;

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
        int[][] mem = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(mem[0], 1);
        for (int i = 1; i <= t.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                mem[i][j] = mem[i][j - 1];
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    mem[i][j] += mem[i - 1][j - 1];
                }
            }
        }
        return mem[t.length()][s.length()];
    }
}
