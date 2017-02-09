/**
 * <h1>274. H-Index</h1>
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h
 * citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had
 * received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
 * <p>
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 *
 * @author Jerry
 * @since 2/8/17
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int[] buckets = new int[citations.length + 1];
        for (int num : citations) {
            buckets[Math.min(num, citations.length)]++;
        }
        int h = citations.length, sum = buckets[h];
        while (h > 0 && sum < h) {
            sum += buckets[--h];
        }
        return h;
    }
}
