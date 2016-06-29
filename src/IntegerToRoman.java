/**
 * <h1>12. Container With Most Water</h1>
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 * @author Jerry
 * @since 6/29/16
 */
public class IntegerToRoman {
    private StringBuilder sb;

    private void convert(int num, int unit, char one, char five, char ten) {
        while (num >= unit) {
            if (num >= 9 * unit) {
                sb.append(one).append(ten);
                num -= 9 * unit;
            } else if (num >= 5 * unit) {
                sb.append(five);
                num -= 5 * unit;
            } else if (num >= 4 * unit) {
                sb.append(one).append(five);
                num -= 4 * unit;
            } else {
                sb.append(one);
                num -= unit;
            }
        }
    }

    public String intToRoman(int num) {
        sb = new StringBuilder();
        while (num >= 1000) {
            sb.append("M");
            num -= 1000;
        }
        convert(num % 1000, 100, 'C', 'D', 'M');
        convert(num % 100, 10, 'X', 'L', 'C');
        convert(num % 10, 1, 'I', 'V', 'X');
        return sb.toString();
    }
}
