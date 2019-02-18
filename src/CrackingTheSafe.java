import java.util.HashSet;
import java.util.Set;

/**
 * <h1>753. Cracking the Safe</h1>
 * There is a box protected by a password. The password is n digits, where each letter can be one of the first k digits 0, 1, ..., k-1.
 * You can keep inputting the password, the password will automatically be matched against the last n digits entered.
 * For example, assuming the password is "345", I can open it when I type "012345", but I enter a total of 6 digits.
 * Please return any string of minimum length that is guaranteed to open the box after the entire string is inputted.
 * <p>
 * Example 1: Input: n = 1, k = 2. Output: "01". Note: "10" will be accepted too.
 * <p>
 * Example 2: Input: n = 2, k = 2. Output: "00110". Note: "01100", "10011", "11001" will be accepted too.
 * <p>
 * Note:
 * n will be in the range [1, 4].
 * k will be in the range [1, 10].
 * k^n will be at most 4096.
 *
 * @author Jerry
 * @since 2/17/19
 */
public class CrackingTheSafe {
    public String crackSafe(int n, int k) {
        if (n == 1 && k == 1) return "0";

        String start = "";
        for (int i = 0; i < n - 1; i++) start += "0";

        StringBuilder ans = new StringBuilder();
        dfs(start, k, ans, new HashSet<>());
        ans.append(start);
        return ans.toString();
    }

    public void dfs(String node, int k, StringBuilder ans, Set<String> visited) {
        for (int x = 0; x < k; ++x) {
            String nei = node + x;
            if (visited.add(nei)) {
                dfs(nei.substring(1), k, ans, visited);
                ans.append(x);
            }
        }
    }
}
