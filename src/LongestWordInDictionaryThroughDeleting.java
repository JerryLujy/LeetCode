import java.util.List;

/**
 * <h1>524. Longest Word in Dictionary through Deleting</h1>
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting
 * some characters of the given string. If there are more than one possible results, return the longest word with the
 * smallest lexicographical order. If there is no possible result, return the empty string.
 * <p>
 * Example 1: Input: s = "abpcplea", d = ["ale","apple","monkey","plea"], Output: "apple"
 * <p>
 * Example 2: Input: s = "abpcplea", d = ["a","b","c"], Output: "a"
 * <p>
 * Note:
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 *
 * @author Jerry
 * @since 1/22/19
 */
public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String ans = "";
        for (String ss : d) {
            if (isSubsequence(s, ss) && (ss.length() > ans.length() || (ss.length() == ans.length() && ss.compareTo(ans) < 0))) {
                ans = ss;
            }
        }
        return ans;
    }

    private boolean isSubsequence(String s, String seq) {
        int ind = -1;
        for (int i = 0; i < seq.length(); i++) {
            if ((ind = s.indexOf(seq.charAt(i), ind + 1)) < 0) {
                return false;
            }
        }
        return true;
    }
}
