import java.util.ArrayList;
import java.util.List;

/**
 * <h1>809. Expressive Words</h1>
 * Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".
 * Here, we have groups, of adjacent letters that are all the same character, and adjacent characters to the group are different.
 * A group is extended if that group is length 3 or more, so "e" and "o" would be extended in the first example,
 * and "i" would be extended in the second example.
 * As another example, the groups of "abbcccaaaa" would be "a", "bb", "ccc", and "aaaa"; and "ccc" and "aaaa" are the extended groups of that string.
 * For some given string S, a query word is stretchy if it can be made to be equal to S by extending some groups.
 * Formally, we are allowed to repeatedly choose a group (as defined above) of characters c,
 * and add some number of the same character c to it so that the length of the group is 3 or more.
 * Note that we cannot extend a group of size one like "h" to a group of size two like "hh" - all extensions must leave the group extended - ie., at least 3 characters long.
 * Given a list of query words, return the number of words that are stretchy.
 * <p>
 * Example:
 * Input:
 * S = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * Output: 1
 * Explanation:
 * We can extend "e" and "o" in the word "hello" to get "heeellooo".
 * We can't extend "helo" to get "heeellooo" because the group "ll" is not extended.
 * <p>
 * Notes:
 * 0 <= len(S) <= 100.
 * 0 <= len(words) <= 100.
 * 0 <= len(words[i]) <= 100.
 * S and all words in words consist only of lowercase letters
 *
 * @author Jerry
 * @since 1/30/19
 */
public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        RunLengthEncode srle = new RunLengthEncode(S);
        int ans = 0;
        for (String word : words) {
            RunLengthEncode wrle = new RunLengthEncode(word);
            if (!srle.key.equals(wrle.key)) {
                continue;
            }
            boolean valid = true;
            for (int i = 0; i < wrle.counts.size(); i++) {
                int cs = srle.counts.get(i), cw = wrle.counts.get(i);
                if (cs < cw || cs < 3 && cs != cw) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                ans++;
            }
        }
        return ans;
    }

    private static class RunLengthEncode {
        String key;
        List<Integer> counts;

        RunLengthEncode(String s) {
            StringBuilder sb = new StringBuilder();
            counts = new ArrayList<>();
            int prev = -1;
            for (int i = 0; i < s.length(); i++) {
                if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                    sb.append(s.charAt(i));
                    counts.add(i - prev);
                    prev = i;
                }
            }
            key = sb.toString();
        }
    }
}
