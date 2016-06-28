/**
 * <h1>9. Palindrome Number</h1>
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * @author Jerry
 * @since 6/27/16
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }
        int digits = 1, tmp = x;
        while (tmp >= 10) {
            tmp /= 10;
            digits++;
        }
        for (int i = 0; i < digits / 2; i++) {
            int lsd = x / (int) Math.pow(10, i) % 10;
            int msd = x / (int) Math.pow(10, digits - i - 1) % 10;
            if (lsd != msd) {
                return false;
            }
        }
        return true;
    }
}
