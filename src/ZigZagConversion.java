/**
 * <h1>6. ZigZag Conversion</h1>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows.
 *
 * @author Jerry
 * @since 5/26/16
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int period = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            int ind = i;
            while (ind < s.length()) {
                sb.append(s.charAt(ind));
                if (i != 0 && i != numRows - 1) {// Not first nor the last row
                    int next = ind + 2 * (numRows - 1 - i);
                    if (next < s.length()) {
                        sb.append(s.charAt(next));
                    }
                }
                ind += period;
            }
        }
        return sb.toString();
    }
}
