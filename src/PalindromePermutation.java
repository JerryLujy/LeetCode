import java.util.HashSet;
import java.util.Set;

/**
 * <h1>266. Palindrome Permutation</h1>
 * Given a string, determine if a permutation of the string could form a palindrome.
 * <p>
 * For example, "code" -> False, "aab" -> True, "carerac" -> True.
 *
 * @author Jerry
 * @since 2/5/17
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            }
        }
        return set.size() < 2;
    }
}
