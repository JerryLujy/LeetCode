import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>30. Substring with Concatenation of All Words</h1>
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and
 * without any intervening characters.
 * <p>
 * For example, given: s: "barfoothefoobarman" words: ["foo", "bar"]
 * You should return the indices: [0,9]. (order does not matter).
 *
 * @author Jerry
 * @since 8/21/16
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || words == null) {
            return ans;
        }
        int m = words.length;
        if (m == 0) {
            return ans;
        }
        int n = words[0].length();

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
        }

        Map<String, Integer> curMap = new HashMap<>();
        for (int i = 0; i < s.length() - n * m + 1; i++) {
            curMap.clear();
            int j = 0;
            for (; j < m; j++) {
                String part = s.substring(i + n * j, i + n * j + n);
                if (!map.containsKey(part)) {
                    break;
                }
                curMap.put(part, curMap.containsKey(part) ? curMap.get(part) + 1 : 1);
                if (curMap.get(part) > map.get(part)) {
                    break;
                }
            }
            if (j == m) {
                ans.add(i);
            }
        }
        return ans;
    }
}
