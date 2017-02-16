/**
 * <h1>306. Additive Number</h1>
 * Additive number is a string whose digits can form additive sequence. A valid additive sequence should contain at least three numbers.
 * Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * <p>
 * For example: "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * <p>
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * <p>
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * <p>
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 *
 * @author Jerry
 * @since 2/15/17
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int i = 1; i < num.length() - 1; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                return false;
            }
            long num1 = Long.parseLong(num.substring(0, i));
            for (int j = i + 1; j < num.length(); j++) {
                if (num.charAt(i) == '0' && j > i + 1) {
                    break;
                }
                long num2 = Long.parseLong(num.substring(i, j));
                if (isAdditive(num, j, num1, num2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdditive(String num, int ind, long num1, long num2) {
        if (ind == num.length()) {
            return true;
        }
        String sum = String.valueOf(num1 + num2);
        return num.startsWith(sum, ind) && isAdditive(num, ind + sum.length(), num2, num1 + num2);
    }
}
