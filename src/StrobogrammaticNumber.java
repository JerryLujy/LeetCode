/**
 * <h1>246. Strobogrammatic Number</h1>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * <p>
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 *
 * @author Jerry
 * @since 2/3/17
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int len = num.length();
        for (int i = 0; i < len / 2; i++) {
            if (!valid(num.charAt(i), num.charAt(len - i - 1))) {
                return false;
            }
        }
        return len % 2 == 0 || valid(num.charAt(len / 2));
    }

    private boolean valid(char a) {
        return a == '0' || a == '1' || a == '8';
    }

    private boolean valid(char a, char b) {
        return a == '6' && b == '9' || a == '9' && b == '6' || a == '8' && b == '8' ||
                a == '0' && b == '0' || a == '1' && b == '1';
    }
}
