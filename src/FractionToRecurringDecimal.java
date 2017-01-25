import java.util.HashMap;
import java.util.Map;

/**
 * <h1>166. Fraction to Recurring Decimal</h1>
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * For example, Given numerator = 1, denominator = 2, return "0.5". Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 *
 * @author Jerry
 * @since 1/25/17
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }
        long num = Math.abs((long) numerator), den = Math.abs((long) denominator);
        sb.append(num / den);
        num %= den;
        if (num == 0) {
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> posMap = new HashMap<>();
        while (num != 0 && !posMap.containsKey(num)) {
            posMap.put(num, sb.length());
            num *= 10;
            sb.append(num / den);
            num %= den;
        }
        if (posMap.containsKey(num)) {
            sb.insert(posMap.get(num), "(");
            sb.append(")");
        }
        return sb.toString();
    }
}
