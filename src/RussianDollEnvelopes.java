import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <h1>354. Russian Doll Envelopes</h1>
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * <p>
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * <p>
 * Example: Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 *
 * @author Jerry
 * @since 2/27/17
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        List<int[]> list = Arrays.asList(envelopes);
        list.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparing(Comparator.comparingInt((int[] a) -> a[1])));
        int[] dp = new int[list.size()];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < dp.length; i++) {
            int[] cur = list.get(i);
            for (int j = 0; j < i; j++) {
                int[] prev = list.get(j);
                if (prev[0] < cur[0] && prev[1] < cur[1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
