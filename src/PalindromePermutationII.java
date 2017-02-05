import java.util.*;

/**
 * <h1>267. Palindrome Permutation II</h1>
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
 * <p>
 * For example: Given s = "aabb", return ["abba", "baab"]. Given s = "abc", return [].
 *
 * @author Jerry
 * @since 2/5/17
 */
public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        List<Character> charList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
                charList.add(c);
            }
        }
        if (set.size() > 1) {
            return ans;
        }
        Collections.sort(charList);
        String mid = set.size() == 0 ? "" : String.valueOf(set.iterator().next());

        generatePalindromes(ans, new StringBuilder(), s.length() / 2, charList, new boolean[charList.size()], mid);

        return ans;
    }

    private void generatePalindromes(List<String> ans, StringBuilder sb, int len, List<Character> charList, boolean[] used, String mid) {
        if (sb.length() == len) {
            ans.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
        }
        for (int i = 0; i < charList.size(); i++) {
            if (!used[i] && (i == 0 || used[i - 1] || !charList.get(i).equals(charList.get(i - 1)))) {
                used[i] = true;
                sb.append(charList.get(i));
                generatePalindromes(ans, sb, len, charList, used, mid);
                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }
    }
}
