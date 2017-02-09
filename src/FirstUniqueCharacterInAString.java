/**
 * <h1>387. First Unique Character in a String</h1>
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples: s = "leetcode", return 0. s = "loveleetcode", return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 * @author Jerry
 * @since 2/8/17
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
