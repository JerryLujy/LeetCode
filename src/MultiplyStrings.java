import java.util.Arrays;

/**
 * <h1>43. Multiply Strings</h1>
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * <p>
 * Note: The numbers can be arbitrarily large and are non-negative. Converting the input string to integer is NOT allowed.
 * You should NOT use internal library such as BigInteger.
 *
 * @author Jerry
 * @since 8/24/16
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        MultiplyStrings m = new MultiplyStrings();
        System.out.println(m.multiply("73874657813649562378465723645726389452", "5267893465782634756238745263745"));
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        char[] res = new char[arr1.length + arr2.length];
        Arrays.fill(res, '0');
        for (int i = arr2.length - 1; i >= 0; i--) {
            char[] tmp = mult(arr1, arr2[i]);
            add(res, tmp, arr2.length - 1 - i);
        }
        int i = 0;
        while (res[i] == '0') {
            i++;
        }
        return String.valueOf(res, i, res.length - i);
    }

    private void add(char[] num1, char[] num2, int offset) {// Add num2 to num1, with position offset
        int carry = 0;
        int num2ind = num2.length - 1;
        for (int i = num1.length - 1 - offset; i >= 0; i--) {
            int sum = carry + num1[i] - '0';
            if (num2ind >= 0) {
                sum += num2[num2ind] - '0';
            }
            carry = sum / 10;
            num1[i] = (char) (sum % 10 + '0');
            num2ind--;
        }
    }

    private char[] mult(char[] num1, char num2) {
        char[] res = new char[num1.length + 1];
        Arrays.fill(res, '0');
        if (num2 == 0) {
            return res;
        }
        int carry = 0;
        for (int i = num1.length - 1; i >= 0; i--) {
            int prod = mult(num1[i], num2) + carry;
            carry = prod / 10;
            res[i + 1] = (char) (prod % 10 + '0');
        }
        res[0] += carry;
        return res;
    }

    private int mult(char num1, char num2) {
        return (num1 - '0') * (num2 - '0');
    }
}
