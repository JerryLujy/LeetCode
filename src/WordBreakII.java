import java.util.*;

/**
 * <h1>140. Word Break II</h1>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * You may assume the dictionary does not contain duplicate words.
 * Return all such possible sentences.
 * <p>
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 *
 * @author Jerry
 * @since 1/21/17
 */
public class WordBreakII {
    private int longest = 0;// Longest word in dictionary

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String word : wordDict) {
            dict.add(word);
            longest = Math.max(longest, word.length());
        }
        Map<Integer, List<String>> mem = new HashMap<>();
        return wordBreak(s, dict, 0, mem);
    }

    private List<String> wordBreak(String s, Set<String> dict, int ind, Map<Integer, List<String>> mem) {
        if (mem.containsKey(ind)) {
            return mem.get(ind);
        }
        List<String> ans = new ArrayList<>();
        for (int i = ind; i < ind + longest && i < s.length(); i++) {
            String sub = s.substring(ind, i + 1);
            if (dict.contains(sub)) {
                if (i + 1 == s.length()) {// We have reached the end, answer is the last word
                    ans.add(sub);
                } else {
                    List<String> remains = wordBreak(s, dict, i + 1, mem);
                    for (String remain : remains) {
                        ans.add(sub + " " + remain);
                    }
                }
            }
        }
        mem.put(ind, ans);
        return ans;
    }
}
