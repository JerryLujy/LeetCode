/**
 * <h1>392. Is Subsequence</h1>
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1: s = "abc", t = "ahbgdc". Return true.
 * <p>
 * Example 2: s = "axc", t = "ahbgdc". Return false.
 *
 * @author Jerry
 * @since 3/13/17
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        for (int sind = 0, tind = 0; tind < t.length(); ) {
            if (t.charAt(tind) == s.charAt(sind)) {
                if (++sind == s.length()) {
                    return true;
                }
            }
            tind++;
        }
        return false;
    }
}
