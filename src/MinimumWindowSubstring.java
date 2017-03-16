/**
 * <h1>76. Minimum Window Substring</h1>
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * @author Jerry
 * @since 9/1/16
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] smap = new int[256];
        int[] tmap = new int[256];
        for (char c : t.toCharArray()) {
            tmap[c]++;
        }
        int l = 0, r = 0, minl = 0, minr = 0, minLen = s.length() + 1;
        int count = t.length(); // Number of characters still need to be matched
        while (r < s.length()) {
            smap[s.charAt(r)]++;
            if (smap[s.charAt(r)] <= tmap[s.charAt(r)]) {
                count--;
            }
            r++;
            if (count == 0) {
                while (smap[s.charAt(l)] > tmap[s.charAt(l)]) {
                    smap[s.charAt(l++)]--;
                }
                if (r - l < minLen) {
                    minLen = r - l;
                    minl = l;
                    minr = r;
                }
            }
        }
        return count == 0 ? s.substring(minl, minr) : "";
    }
}
