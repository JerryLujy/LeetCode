import java.util.HashMap;
import java.util.Map;

/**
 * <h1>159. Longest Substring with At Most Two Distinct Characters</h1>
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * For example, Given s = “eceba”, T is "ece" which its length is 3.
 *
 * @author Jerry
 * @since 1/24/17
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> positions = new HashMap<>();
        int ans = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            positions.put(s.charAt(j), j);
            if (positions.size() > 2) {
                int leftMost = Integer.MAX_VALUE;
                for (int pos : positions.values()) {
                    leftMost = Math.min(leftMost, pos);
                }
                positions.remove(s.charAt(leftMost));
                i = leftMost + 1;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
