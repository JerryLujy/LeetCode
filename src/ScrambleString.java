import java.util.Arrays;

/**
 * <h1>87. Scramble String</h1>
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * Below is one possible representation of s1 = "great": (gr)(e(at))
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * <p>
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string (rg)(e(at))
 * We say that "rgeat" is a scrambled string of "great".
 * <p>
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string (rg)((ta)e)
 * We say that "rgtae" is a scrambled string of "great".
 * <p>
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 * @author Jerry
 * @since 9/3/16
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if (len < 2) {
            return s1.equals(s2);
        }
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        if (!Arrays.equals(a1, a2)) {
            return false;
        }
        for (int k = 1; k < len; k++) {
            if (isScramble(s1.substring(0, k), s2.substring(0, k)) &&
                    isScramble(s1.substring(k, len), s2.substring(k, len))) {
                return true;
            }
            if (isScramble(s1.substring(0, k), s2.substring(len - k, len)) &&
                    isScramble(s1.substring(k, len), s2.substring(0, len - k))) {
                return true;
            }
        }
        return false;
    }

    public boolean isScramble2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        boolean[][][] mem = new boolean[len][len][len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                mem[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len - l + 1; i++) {
                for (int j = 0; j < len - l + 1; j++) {
                    for (int k = 1; k < l; k++) {
                        mem[i][j][l] |= mem[i][j][k] && mem[i + k][j + k][l - k] || mem[i][j + l - k][k] && mem[i + k][j][l - k];
                    }
                }
            }
        }
        return mem[0][0][len];
    }
}
