/**
 * <h1>926. Flip String to Monotone Increasing</h1>
 * A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0), followed by some number of '1's (also possibly 0.)
 * We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.
 * Return the minimum number of flips to make S monotone increasing.
 * <p>
 * Example 1: Input: "00110", Output: 1. Explanation: We flip the last digit to get 00111.
 * <p>
 * Example 2: Input: "010110", Output: 2. Explanation: We flip to get 011111, or alternatively 000111.
 * <p>
 * Example 3: Input: "00011000", Output: 2. Explanation: We flip to get 00000000.
 * <p>
 * Note:
 * 1 <= S.length <= 20000
 * S only consists of '0' and '1' characters.
 *
 * @author Jerry
 * @since 2/4/19
 */
public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String S) {
        // T[i] = min flip to make S[i:end] monotone
        // T[i] = T[i + 1]                                , if S[i] == 0
        //      = min(1 + T[i + 1], #zeros from T[i + 1]) , if S[i] == 1
        int ans = 0, numZero = S.charAt(S.length() - 1) == '0' ? 1 : 0;
        for (int i = S.length() - 2; i >= 0; i--) {
            if (S.charAt(i) == '1') {
                ans = Math.min(1 + ans, numZero);
            }
            numZero += S.charAt(i) == '0' ? 1 : 0;
        }
        return ans;
    }
}
