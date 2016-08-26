/**
 * <h1>10. Regular Expression Matching</h1>
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character. '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Some examples:
 * <p>
 * isMatch("aa","a") -> false
 * <p>
 * isMatch("aa","aa") -> true
 * <p>
 * isMatch("aaa","aa") -> false
 * <p>
 * isMatch("aa", "a*") -> true
 * <p>
 * isMatch("aa", ".*") -> true
 * <p>
 * isMatch("ab", ".*") -> true
 * <p>
 * isMatch("aab", "c*a*b") -> true
 *
 * @author Jerry
 * @since 8/25/16
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return match(s, 0, p, 0);
    }

    private boolean match(String s, int sind, String p, int pind) {
        if (pind == p.length()) {
            return sind == s.length();
        }
        if (sind == s.length()) {
            // Checks if p matches empty string
            if ((p.length() - pind) % 2 != 0) {
                return false;
            }
            for (int i = pind + 1; i < p.length(); i += 2) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (pind + 1 < p.length() && p.charAt(pind + 1) == '*') {
            if (p.charAt(pind) == '.' || p.charAt(pind) == s.charAt(sind)) {
                return match(s, sind + 1, p, pind) || match(s, sind, p, pind + 2);// match once or don't match
            } else {
                return match(s, sind, p, pind + 2);// does not match
            }
        }
        return (p.charAt(pind) == '.' || p.charAt(pind) == s.charAt(sind)) && match(s, sind + 1, p, pind + 1);
    }
}
