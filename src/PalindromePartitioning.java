import java.util.ArrayList;
import java.util.List;

/**
 * <h1>131. Palindrome Partitioning</h1>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * <p>
 * For example, given s = "aab", Return [["aa","b"],["a","a","b"]]
 *
 * @author Jerry
 * @since 1/20/17
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        isPalindrome[0][0] = true;
        for (int i = 1; i < len; i++) {
            isPalindrome[i][i] = true;
            isPalindrome[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }
        for (int i = 2; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                isPalindrome[j][j + i] = isPalindrome[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> partitions = new ArrayList<>();
        getPartitions(isPalindrome, ans, partitions, s, 0);
        return ans;
    }

    private void getPartitions(boolean[][] isPalindrome, List<List<String>> ans, List<String> partition, String s, int ind) {
        if (ind == s.length()) {
            ans.add(new ArrayList<>(partition));
            return;
        }
        for (int i = ind; i < s.length(); i++) {
            if (isPalindrome[ind][i]) {
                partition.add(s.substring(ind, i + 1));
                getPartitions(isPalindrome, ans, partition, s, i + 1);
                partition.remove(partition.size() - 1);
            }
        }
    }
}
