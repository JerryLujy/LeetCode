import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>273. Integer to English Words</h1>
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.
 * <p>
 * For example,
 * 123 -> "One Hundred Twenty Three",
 * 12345 -> "Twelve Thousand Three Hundred Forty Five",
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * @author Jerry
 * @since 2/7/17
 */
public class IntegerToEnglishWords {
    private static Map<Integer, String> ones = new HashMap<>();
    private static Map<Integer, String> teens = new HashMap<>();
    private static Map<Integer, String> tens = new HashMap<>();
    private static List<String> thousands = Arrays.asList("Thousand", "Million", "Billion");

    static {
        ones.put(1, "One");ones.put(2,"Two");ones.put(3, "Three");ones.put(4,"Four");ones.put(5,"Five");
        ones.put(6,"Six");ones.put(7,"Seven");ones.put(8,"Eight");ones.put(9,"Nine");
        teens.put(10, "Ten");teens.put(11, "Eleven");teens.put(12, "Twelve");teens.put(13, "Thirteen");
        teens.put(14, "Fourteen");teens.put(15, "Fifteen");teens.put(16, "Sixteen");teens.put(17, "Seventeen");
        teens.put(18, "Eighteen");teens.put(19, "Nineteen");
        tens.put(20, "Twenty");tens.put(30, "Thirty");tens.put(40, "Forty");tens.put(50, "Fifty");
        tens.put(60, "Sixty");tens.put(70, "Seventy");tens.put(80, "Eighty");tens.put(90, "Ninety");
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int thousandInd = -1;
        String ans = "";
        while (num > 0) {
            if (num % 1000 > 0) {
                ans = printThousands(num % 1000) + " " + ans;
            }
            num = num / 1000;
            thousandInd++;
            if (num % 1000 > 0) {
                ans = thousands.get(thousandInd) + " " + ans;
            }
        }
        return ans.trim();
    }

    private String printThousands(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            sb.append(ones.get(num / 100)).append(" Hundred ");
        }
        num %= 100;
        if (num >= 10 && num <= 19) {
            sb.append(teens.get(num));
            return sb.toString();
        }
        if (num >= 20) {
            sb.append(tens.get(num / 10 * 10)).append(" ");
        }
        num %= 10;
        if (num > 0) {
            sb.append(ones.get(num));
        }
        return sb.toString().trim();
    }
}
