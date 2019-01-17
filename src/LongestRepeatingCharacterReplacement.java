/**
 * <h1>424. Longest Repeating Character Replacement</h1>
 * Given a string that consists of only uppercase English letters,
 * you can replace any letter in the string with another letter at most k times.
 * Find the length of a longest substring containing all repeating letters you can get after performing the above operations.
 *
 * Note: Both the string's length and k will not exceed 10^4.
 * <p>
 * Example 1: Input: s = "ABAB", k = 2, Output: 4. Explanation: Replace the two 'A's with two 'B's or vice versa.
 * <p>
 * Example 2: Input: s = "AABABBA", k = 1, Output: 4. Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 *
 * @author Jerry
 * @since 1/17/19
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0, ans = 0;
        int[] freq = new int[26];
        for (int l = 0, r = 0; r < s.length(); r++) {
            maxFreq = Math.max(maxFreq, ++freq[s.charAt(r) - 'A']);
            while (r - l + 1 - maxFreq > k) {
                freq[s.charAt(l++) - 'A']--;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
