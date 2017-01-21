import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h1>139. Word Break</h1>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * You may assume the dictionary does not contain duplicate words.
 * <p>
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * @author Jerry
 * @since 1/21/17
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        Set<String> dict = new HashSet<>();
        int longest = 0;
        for (String word : wordDict) {
            dict.add(word);
            longest = Math.max(longest, word.length());
        }
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i < longest) {
                dp[i] = dict.contains(s.substring(0, i + 1));
            }
            for (int j = Math.max(1, i - longest + 1); j <= i; j++) {
                dp[i] |= dp[j - 1] && dict.contains(s.substring(j, i + 1));
            }
        }
        return dp[s.length() - 1];
    }
}
