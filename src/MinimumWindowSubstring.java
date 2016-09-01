import java.util.HashMap;
import java.util.Map;

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
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!tmap.containsKey(c)) {
                tmap.put(c, 0);
            }
            if (!smap.containsKey(c)) {
                smap.put(c, 0);
            }
            tmap.put(c, tmap.get(c) + 1);
        }
        String ans = "";
        int l = 0;
        int r = 0;
        for (; l < s.length(); l++) {
            while (!containsAll(tmap, smap) && r < s.length()) {
                char cur = s.charAt(r);
                if (smap.containsKey(cur)) {
                    smap.put(cur, smap.get(cur) + 1);
                }
                r++;
            }
            if (containsAll(tmap, smap) && (ans.length() == 0 || r - l < ans.length())) {
                ans = s.substring(l, r);
            }
            char toRemove = s.charAt(l);
            if (smap.containsKey(toRemove)) {
                smap.put(toRemove, smap.get(toRemove) - 1);
            }
        }
        return ans;
    }

    private boolean containsAll(Map<Character, Integer> tmap, Map<Character, Integer> smap) {
        for (Character c : tmap.keySet()) {
            if (smap.get(c) < tmap.get(c)) {
                return false;
            }
        }
        return true;
    }
}
