/**
 * <h1>67. Add Binary</h1>
 * Given two binary strings, return their sum (also a binary string).
 * For example, a = "11", b = "1", return "100".
 *
 * @author Jerry
 * @since 8/30/16
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aind = a.length() - 1;
        int bind = b.length() - 1;
        int carry = 0;
        while (aind >= 0 && bind >= 0) {
            int sum = a.charAt(aind--) - '0' + b.charAt(bind--) - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        while (aind >= 0) {
            int sum = a.charAt(aind--) - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        while (bind >= 0) {
            int sum = b.charAt(bind--) - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
