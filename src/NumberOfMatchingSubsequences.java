import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>792. Number of Matching Subsequences</h1>
 * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.
 * <p>
 * Example: Input: S = "abcde", words = ["a", "bb", "acd", "ace"], Output: 3
 * Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 * <p>
 * Note:
 * All words in words and S will only consists of lowercase letters.
 * The length of S will be in the range of [1, 50000].
 * The length of words will be in the range of [1, 5000].
 * The length of words[i] will be in the range of [1, 50].
 *
 * @author Jerry
 * @since 1/29/19
 */
public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        Map<Character, List<String>> map = new HashMap<>();
        for (String word : words) {
            map.computeIfAbsent(word.charAt(0), k -> new ArrayList<>()).add(word);
        }
        for (char c : S.toCharArray()) {
            if (!map.containsKey(c)) {
                continue;
            }
            List<String> newList = new ArrayList<>();
            for (String s : map.get(c)) {
                if (s.length() == 1) {
                    ans++;
                    continue;
                }
                String newS = s.substring(1);
                if (newS.charAt(0) == c) {
                    newList.add(newS);
                } else {
                    map.computeIfAbsent(newS.charAt(0), k -> new ArrayList<>()).add(newS);
                }
            }
            map.put(c, newList);
        }
        return ans;
    }
}
