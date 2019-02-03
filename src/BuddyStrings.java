/**
 * <h1>859. Buddy Strings</h1>
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in
 * A so that the result equals B.
 * <p>
 * Example 1: Input: A = "ab", B = "ba", Output: true
 * <p>
 * Example 2: Input: A = "ab", B = "ab", Output: false
 * <p>
 * Example 3: Input: A = "aa", B = "aa", Output: true
 * <p>
 * Example 4: Input: A = "aaaaaaabc", B = "aaaaaaacb", Output: true
 * <p>
 * Example 5: Input: A = "", B = "aa", Output: false
 * <p>
 * Note:
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 *
 * @author Jerry
 * @since 2/2/19
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() < 2) {
            return false;
        }
        int a = -1, b = -1;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (a == -1) {
                    a = i;
                } else if (b == -1) {
                    b = i;
                } else {
                    return false;
                }
            }
        }
        if (a != -1) {
            return b != -1 && A.charAt(a) == B.charAt(b) && A.charAt(b) == B.charAt(a);
        }
        int[] count = new int[26];
        for (char c : A.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 1) {
                return true;
            }
        }
        return false;
    }
}
