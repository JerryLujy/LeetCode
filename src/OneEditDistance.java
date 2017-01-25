/**
 * <h1>161. One Edit Distance</h1>
 * Given two strings S and T, determine if they are both one edit distance apart.
 *
 * @author Jerry
 * @since 1/24/17
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i + 1).equals(t.substring(i + 1)) ||
                        s.substring(i).equals(t.substring(i + 1)) ||
                        s.substring(i + 1).equals(t.substring(i));
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
