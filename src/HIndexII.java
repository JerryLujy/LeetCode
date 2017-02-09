/**
 * <h1>275. H-Index II</h1>
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 *
 * @author Jerry
 * @since 2/8/17
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        int len = citations.length, l = 0, r = len - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (citations[m] >= len - m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return len - l;
    }
}
