import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <h1>291. Word Pattern II</h1>
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 * <p>
 * Examples:
 * pattern = "abab", str = "redblueredblue" should return true.
 * pattern = "aaaa", str = "asdasdasdasd" should return true.
 * pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * <p>
 * Notes: You may assume both pattern and str contains only lowercase letters.
 *
 * @author Jerry
 * @since 2/11/17
 */
public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> strings = new HashSet<>();
        return matches(pattern, 0, str, 0, map, strings);
    }

    private boolean matches(String pattern, int pind, String str, int sind, Map<Character, String> map, Set<String> strings) {
        if (sind == str.length()) {
            return pind == pattern.length();
        }
        if (pind == pattern.length()) {
            return sind == str.length();
        }
        char c = pattern.charAt(pind);
        if (map.containsKey(c)) {
            return str.startsWith(map.get(c), sind) &&
                    matches(pattern, pind + 1, str, sind + map.get(c).length(), map, strings);
        } else {
            for (int i = sind + 1; i <= str.length(); i++) {
                String s = str.substring(sind, i);
                if (strings.contains(s)) {
                    continue;
                }
                map.put(c, s);
                strings.add(s);
                if (matches(pattern, pind + 1, str, sind + s.length(), map, strings)) {
                    return true;
                }
                strings.remove(s);
                map.remove(c);
            }
        }
        return false;
    }
}
