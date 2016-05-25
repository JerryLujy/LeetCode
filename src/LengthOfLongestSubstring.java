import java.util.HashMap;
import java.util.Map;

/**
 * <h1>3. Longest Substring Without Repeating Characters</h1>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3.
 *
 * @author Jerry
 * @since 5/25/16
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> posMap = new HashMap<>();
        int left = 0, right = 0;
        int longest = 0;
        for (; right < s.length(); right++) {
            char curr = s.charAt(right);
            if (posMap.containsKey(curr)) {
                left = Math.max(posMap.get(curr) + 1, left);
            }
            longest = Math.max(longest, right - left + 1);
            posMap.put(curr, right);
        }
        return longest;
    }
}
