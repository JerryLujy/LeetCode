import java.util.Random;

/**
 * <h1>528. Random Pick with Weight</h1>
 * Given an array w of positive integers, where w[i] describes the weight of index i,
 * write a function pickIndex which randomly picks an index in proportion to its weight.
 * <p>
 * Note:
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * <p>
 * Example 1: Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * <p>
 * Example 2:
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 *
 * @author Jerry
 * @since 2/2/19
 */
public class RandomPickWithWeight {
    int[] pSum;
    int sum;
    Random random;

    public RandomPickWithWeight(int[] w) {
        random = new Random();
        pSum = new int[w.length];
        sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            pSum[i] = sum;
        }
    }

    public int pickIndex() {
        int rand = random.nextInt(sum) + 1;
        int l = 0, r = pSum.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (pSum[m] == rand) {
                return m;
            } else if (pSum[m] < rand) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
