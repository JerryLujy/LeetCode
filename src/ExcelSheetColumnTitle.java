/**
 * <h1>168. Excel Sheet Column Title</h1>
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example: 1 -> A, 2 -> B, 3 -> C, ..., 26 -> Z, 27 -> AA, 28 -> AB
 *
 * @author Jerry
 * @since 1/25/17
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) ('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
