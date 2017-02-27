import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1>345. Reverse Vowels of a String</h1>
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1: Given s = "hello", return "holle".
 * <p>
 * Example 2: Given s = "leetcode", return "leotcede".
 *
 * @author Jerry
 * @since 2/26/17
 */
public class ReverseVowelsOfAString {
    private static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'o', 'e', 'i', 'u', 'A', 'O', 'E', 'I', 'U'));

    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0, j = sb.length() - 1; i < j; i++, j--) {
            while (i < j && !vowels.contains(sb.charAt(i))) {
                i++;
            }
            while (i < j && !vowels.contains(sb.charAt(j))) {
                j--;
            }
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, tmp);
        }
        return sb.toString();
    }
}
