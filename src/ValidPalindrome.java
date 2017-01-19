/**
 * <h1>125. Valid Palindrome</h1>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome.
 * <p>
 * Note: Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 * @author Jerry
 * @since 1/18/17
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int front = 0, back = s.length() - 1;
        while (front < back) {
            if (!Character.isLetterOrDigit(s.charAt(front))) {
                front++;
            } else if (!Character.isLetterOrDigit(s.charAt(back))) {
                back--;
            } else {
                if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(back))) {
                    return false;
                }
                front++;
                back--;
            }
        }
        return true;
    }
}
