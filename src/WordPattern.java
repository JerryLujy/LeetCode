import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <h1>290. Word Pattern</h1>
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * <p>
 * Notes: You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 *
 * @author Jerry
 * @since 2/11/17
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split("\\s");
        if (arr.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c) && !map.get(c).equals(arr[i])) {
                return false;
            }
            if (!map.containsKey(c) && strings.contains(arr[i])) {
                return false;
            }
            map.put(c, arr[i]);
            strings.add(arr[i]);
        }
        return true;
    }
}
