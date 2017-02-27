import java.util.HashMap;
import java.util.Map;

/**
 * <h1>340. Longest Substring with At Most K Distinct Characters</h1>
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * For example, Given s = “eceba” and k = 2, T is "ece" which its length is 3.
 *
 * @author Jerry
 * @since 2/26/17
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> posMap = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            posMap.put(s.charAt(j), j);
            if (posMap.size() > k) {
                // Find the leftmost occurance
                int leftmost = j;
                for (int pos : posMap.values()) {
                    leftmost = Math.min(leftmost, pos);
                }
                posMap.remove(s.charAt(leftmost));
                i = leftmost + 1;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
