/**
 * <h1>844. Backspace String Compare</h1>
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 * <p>
 * Example 1: Input: S = "ab#c", T = "ad#c". Output: true. Explanation: Both S and T become "ac".
 * <p>
 * Example 2: Input: S = "ab##", T = "c#d#". Output: true. Explanation: Both S and T become "".
 * <p>
 * Example 3: Input: S = "a##c", T = "#a#c". Output: true. Explanation: Both S and T become "c".
 * <p>
 * Example 4: Input: S = "a#c", T = "b". Output: false. Explanation: S becomes "c" while T becomes "b".
 * <p>
 * Note:
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 *
 * @author Jerry
 * @since 2/1/19
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int sb = 0, tb = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    sb++;
                } else if (sb > 0) {
                    sb--;
                } else {
                    break;
                }
                i--;
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    tb++;
                } else if (tb > 0) {
                    tb--;
                } else {
                    break;
                }
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }
            if (i >= 0 != j >= 0) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
