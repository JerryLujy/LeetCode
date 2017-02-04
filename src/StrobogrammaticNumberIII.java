/**
 * <h1>248. Strobogrammatic Number III</h1>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
 * <p>
 * For example, Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
 * <p>
 * Note: Because the range might be a large number, the low and high numbers are represented as string.
 *
 * @author Jerry
 * @since 2/3/17
 */
public class StrobogrammaticNumberIII {
    private int ans = 0;

    public int strobogrammaticInRange(String low, String high) {
        ans = 0;
        for (int len = low.length(); len <= high.length(); len++) {
            helper("", len, low, high);
            helper("0", len, low, high);
            helper("1", len, low, high);
            helper("8", len, low, high);
        }
        return ans;
    }

    private void helper(String cur, int len, String low, String high) {
        if (cur.length() == len) {
            if (len != 1 && cur.charAt(0) == '0') {// Not a valid number
                return;
            }
            if (low.length() == high.length()) {
                if (cur.compareTo(low) >= 0 && cur.compareTo(high) <= 0) {
                    ans++;
                }
            } else if (len == low.length() && cur.compareTo(low) >= 0 ||
                    len == high.length() && cur.compareTo(high) <= 0 ||
                    len > low.length() && len < high.length()) {
                ans++;
            }
        } else if (cur.length() < len) {
            helper("0" + cur + "0", len, low, high);
            helper("1" + cur + "1", len, low, high);
            helper("8" + cur + "8", len, low, high);
            helper("6" + cur + "9", len, low, high);
            helper("9" + cur + "6", len, low, high);
        }
    }
}
