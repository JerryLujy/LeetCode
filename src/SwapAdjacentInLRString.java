/**
 * <h1>777. Swap Adjacent in LR String</h1>
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing
 * one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR".
 * Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.
 * <p>
 * Example: Input: start = "RXXLRXRXL", end = "XRLXXRRLX". Output: True
 * Explanation:
 * We can transform start to end following these steps:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * <p>
 * Note:
 * 1 <= len(start) = len(end) <= 10000.
 * Both start and end will only consist of characters in {'L', 'R', 'X'}.
 *
 * @author Jerry
 * @since 1/29/19
 */
public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false;
        }
        for (int i = 0, j = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                while (end.charAt(j) != 'L') {
                    j++;
                }
                if (i < j++) {
                    return false;
                }
            }
        }
        for (int i = 0, j = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'R') {
                while (end.charAt(j) != 'R') {
                    j++;
                }
                if (i > j++) {
                    return false;
                }
            }
        }
        return true;
    }
}
