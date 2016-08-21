/**
 * <h1>28. Implement strStr()</h1>
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * @author Jerry
 * @since 8/21/16
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
