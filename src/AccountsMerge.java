import java.util.*;

/**
 * <h1>721. Accounts Merge</h1>
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name,
 * and the rest of the elements are emails representing emails of the account.
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email
 * that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people
 * as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name,
 * and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 * <p>
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * <p>
 * Note:
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 *
 * @author Jerry
 * @since 1/26/19
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                graph.computeIfAbsent(email, k -> new ArrayList<>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), k -> new ArrayList<>()).add(email);
                emailToName.put(email, name);
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        for (String email : graph.keySet()) {
            if (visited.contains(email)) {
                continue;
            }
            visited.add(email);
            Queue<String> q = new ArrayDeque<>();
            q.offer(email);
            List<String> component = new ArrayList<>();
            while (!q.isEmpty()) {
                String cur = q.poll();
                component.add(cur);
                for (String next : graph.get(cur)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
            Collections.sort(component);
            component.add(0, emailToName.get(email));
            ans.add(component);
        }
        return ans;
    }
}
