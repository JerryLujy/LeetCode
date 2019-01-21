/**
 * <h1>556. Next Greater Element III</h1>
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the
 * same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.
 *
 * Example 1: Input: 12, Output: 21
 *
 * Example 2: Input: 21, Output: -1
 *
 * @author Jerry
 * @since 1/20/19
 */
public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        if (arr.length < 2) {
            return -1;
        }
        int pos = arr.length - 2;
        while (pos >= 0 && arr[pos] >= arr[pos + 1]) {
            pos--;
        }
        if (pos == -1) {
            return -1;
        }
        int nextPos = pos;
        while (nextPos + 1 < arr.length && arr[nextPos + 1] > arr[pos]) {
            nextPos++;
        }
        char temp = arr[nextPos];
        arr[nextPos] = arr[pos];
        arr[pos] = temp;
        int end = arr.length - 1;
        while (++pos < end) {
            temp = arr[pos];
            arr[pos] = arr[end];
            arr[end--] = temp;
        }
        long val = Long.parseLong(new String(arr));
        return val > Integer.MAX_VALUE ? -1 : (int)val;
    }
}
