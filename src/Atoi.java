/**
 * <h1>8. String to Integer (atoi)</h1>
 * Implement atoi to convert a string to an integer.
 *
 * @author Jerry
 * @since 6/14/16
 */
public class Atoi {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = str.trim();
        long num = 0;
        boolean isNeg = false;
        char[] digits;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            if (str.charAt(0) == '-') {
                isNeg = true;
            }
            digits = str.substring(1).toCharArray();
        } else if (str.charAt(0) <= '9' && str.charAt(0) >= '0') {
            digits = str.toCharArray();
        } else {
            return 0;
        }
        for (char d : digits) {
            if (d > '9' || d < '0') {
                break;
            }
            num = num * 10 + (long) (d - '0');
            if (num > Integer.MAX_VALUE) {
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return isNeg ? -(int) num : (int) num;
    }
}
