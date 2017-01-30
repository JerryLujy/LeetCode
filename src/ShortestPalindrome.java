/**
 * <h1>214. Shortest Palindrome</h1>
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 * <p>
 * For example: Given "aacecaaa", return "aaacecaaa". Given "abcd", return "dcbabcd".
 *
 * @author Jerry
 * @since 1/29/17
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int len = s.length();
        while (len > 1) {
            if (isPalindrome(s, len)) {
                break;
            }
            len--;
        }
        String suffix = s.substring(len);
        return new StringBuilder(suffix).reverse().toString() + s.substring(0, len) + suffix;
    }

    private boolean isPalindrome(String s, int len) {
        int i = 0, j = len - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
