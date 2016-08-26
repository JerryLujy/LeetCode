/**
 * <h1>44. Wildcard Matching</h1>
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character. '*' Matches any sequence of characters (including the empty sequence).
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
 * isMatch("aa", "*") -> true
 * <p>
 * isMatch("aa", "a*") -> true
 * <p>
 * isMatch("ab", "?*") -> true
 * <p>
 * isMatch("aab", "c*a*b") -> false
 *
 * @author Jerry
 * @since 8/25/16
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int sind = 0;
        int pind = 0;
        int star = -1;
        int matchUntil = 0;
        while (sind < s.length()) {
            if (pind < p.length() && (p.charAt(pind) == '?' || p.charAt(pind) == s.charAt(sind))) {
                sind++;
                pind++;
            } else if (pind < p.length() && p.charAt(pind) == '*') {
                matchUntil = sind;
                while (pind < p.length() && p.charAt(pind) == '*') {
                    pind++;
                }
                star = pind - 1;
            } else if (star != -1) {
                pind = star + 1;// Go back to previous star position
                matchUntil++;// Match a wildcard
                sind = matchUntil;// Continue matching
            } else {
                return false;
            }
        }
        for (; pind < p.length(); pind++) {
            if (p.charAt(pind) != '*') {
                return false;
            }
        }
        return true;
    }
}
