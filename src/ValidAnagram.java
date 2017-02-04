import java.util.Arrays;

/**
 * <h1>242. Valid Anagram</h1>
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p>
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car", return false.
 * <p>
 * Note: You may assume the string contains only lowercase alphabets.
 *
 * @author Jerry
 * @since 2/3/17
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] schar = s.toCharArray(), tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        return Arrays.equals(schar, tchar);
    }
}
