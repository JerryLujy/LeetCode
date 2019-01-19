import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h1>438. Find All Anagrams in a String</h1>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * <p>
 * Example 1: Input: s: "cbaebabacd" p: "abc", Output: [0, 6]
 * <p>
 * Example 2: Input: s: "abab" p: "ab", Output: [0, 1, 2]
 *
 * @author Jerry
 * @since 1/18/19
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[26];
        int count = p.length();
        for (char c : p.toCharArray()) {
            map[c - 'a']++;
        }
        for (int l = 0, r = 0; r < s.length(); r++) {
            if (map[s.charAt(r) - 'a']-- > 0) {
                count--;
            }
            if (count == 0) {
                ans.add(l);
            }
            if (r - l + 1 == p.length()) {
                if (map[s.charAt(l) - 'a']++ >= 0) {
                    count++;
                }
                l++;
            }
        }
        return ans;
    }
}
