/**
 * <h1>5. Longest Palindromic Substring</h1>
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 *
 * @author Jerry
 * @since 5/26/16
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int left = 0, right = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = expandPalindrome(s, i, i);
            int len2 = expandPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > right - left + 1) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    private static int expandPalindrome(String s, int ind1, int ind2) {
        while (ind1 >= 0 && ind2 < s.length() && s.charAt(ind1) == s.charAt(ind2)) {
            ind1--;
            ind2++;
        }
        return ind2 - ind1 - 1;
    }
}
