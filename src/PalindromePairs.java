import java.util.*;

/**
 * <h1>336. Palindrome Pairs</h1>
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * <p>
 * Example 1: Given words = ["bat", "tab", "cat"], Return [[0, 1], [1, 0]]. The palindromes are ["battab", "tabbat"]
 * <p>
 * Example 2: Given words = ["abcd", "dcba", "lls", "s", "sssll"], Return [[0, 1], [1, 0], [3, 2], [2, 4]].
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 *
 * @author Jerry
 * @since 2/25/17
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            dict.put(words[i], i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int k = 0; k <= words[i].length(); k++) {
                String prefix = words[i].substring(0, k);
                String suffix = words[i].substring(k);
                if (isPalindrome(prefix)) {
                    String suffixRev = new StringBuilder(suffix).reverse().toString();
                    if (dict.containsKey(suffixRev) && dict.get(suffixRev) != i) {
                        ans.add(new ArrayList<>(Arrays.asList(dict.get(suffixRev), i)));
                    }
                }
                if (isPalindrome(suffix)) {
                    String prefixRev = new StringBuilder(prefix).reverse().toString();
                    if (dict.containsKey(prefixRev) && dict.get(prefixRev) != i && suffix.length() > 0) {
                        ans.add(new ArrayList<>(Arrays.asList(i, dict.get(prefixRev))));
                    }
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String word) {
        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
