import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <h1>890. Find and Replace Pattern</h1>
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter
 * x in the pattern with p(x), we get the desired word.
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter,
 * and no two letters map to the same letter.)
 * Return a list of the words in words that match the given pattern.
 * You may return the answer in any order.
 * <p>
 * Example 1: Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb". Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
 * <p>
 * Note:
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 *
 * @author Jerry
 * @since 2/2/19
 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        return Arrays.stream(words).filter(s -> match(s, pattern)).collect(Collectors.toList());
    }

    private boolean match(String a, String b) {
        Map<Character, Character> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char ca = a.charAt(i), cb = b.charAt(i);
            map1.putIfAbsent(ca, cb);
            map2.putIfAbsent(cb, ca);
            if (map1.get(ca) != cb || map2.get(cb) != ca) {
                return false;
            }
        }
        return true;
    }
}
