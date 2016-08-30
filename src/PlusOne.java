/**
 * <h1>66. Plus One</h1>
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * @author Jerry
 * @since 8/30/16
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int ind = digits.length - 1;
        while (ind >= 0 && digits[ind] == 9) {
            digits[ind] = 0;
            ind--;
        }
        if (ind == -1) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            return newArr;
        }
        digits[ind] += 1;
        return digits;
    }
}
