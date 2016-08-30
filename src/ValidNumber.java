/**
 * <h1>65. Valid Number</h1>
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 *
 * @author Jerry
 * @since 8/30/16
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < s.length() && Character.isWhitespace(s.charAt(l))) l++;
        if (l == s.length()) {
            return false;
        }
        if (s.charAt(l) == '+' || s.charAt(l) == '-') {
            l++;
        }
        while (Character.isWhitespace(s.charAt(r))) r--;

        boolean validNum = false;
        boolean afterPnt = false;
        boolean afterExp = false;
        while (l <= r) {
            if (Character.isDigit(s.charAt(l))) {
                validNum = true;
            } else if (s.charAt(l) == '.') {
                if (afterPnt || afterExp) {
                    return false;
                }
                afterPnt = true;
            } else if (s.charAt(l) == 'e') {
                if (!validNum || afterExp) {
                    return false;
                }
                validNum = false;
                afterExp = true;
            } else if (s.charAt(l) == '+' || s.charAt(l) == '-') {
                if (s.charAt(l - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            l++;
        }
        return validNum;
    }
}
