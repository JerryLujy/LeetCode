/**
 * <h1>318. Maximum Product of Word Lengths</h1>
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters.
 * You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * <p>
 * Example 1: Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"], Return 16. The two words can be "abcw", "xtfn".
 * <p>
 * Example 2: Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"], Return 4. The two words can be "ab", "cd".
 * <p>
 * Example 3: Given ["a", "aa", "aaa", "aaaa"], Return 0. No such pair of words.
 *
 * @author Jerry
 * @since 2/19/17
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int[] signatures = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                signatures[i] |= 1 << (c - 'a');
            }
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((signatures[i] & signatures[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
