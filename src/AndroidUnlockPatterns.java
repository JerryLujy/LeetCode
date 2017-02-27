/**
 * <h1>351. Android Unlock Patterns</h1>
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9,
 * count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.
 * <p>
 * Rules for a valid pattern:
 * Each pattern must connect at least m keys and at most n keys. All the keys must be distinct.
 * If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern.
 * No jumps through non selected key is allowed. The order of keys used matters.
 * <p>
 * Explanation:
 * <p>
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * <p>
 * Invalid move: 4 - 1 - 3 - 6: Line 1 - 3 passes through key 2 which had not been selected in the pattern.
 * <p>
 * Invalid move: 4 - 1 - 9 - 2: Line 1 - 9 passes through key 5 which had not been selected in the pattern.
 * <p>
 * Valid move: 2 - 4 - 1 - 3 - 6: Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
 * <p>
 * Valid move: 6 - 5 - 4 - 1 - 9 - 2: Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
 * <p>
 * Example: Given m = 1, n = 1, return 9.
 *
 * @author Jerry
 * @since 2/27/17
 */
public class AndroidUnlockPatterns {
    public int numberOfPatterns(int m, int n) {
        int ans = 0;
        boolean[] used = new boolean[9];
        for (int i = m; i <= n; i++) {
            ans += dfs(0, i - 1, used) * 4;
            ans += dfs(1, i - 1, used) * 4;
            ans += dfs(4, i - 1, used);
        }
        return ans;
    }

    private int dfs(int cur, int len, boolean[] used) {
        if (len == 0) {
            return 1;
        }
        int ans = 0;
        used[cur] = true;
        for (int i = 0; i < 9; i++) {
            if (valid(cur, i, used)) {
                ans += dfs(i, len - 1, used);
            }
        }
        used[cur] = false;
        return ans;
    }

    private boolean valid(int prev, int curr, boolean[] used) {
        if (used[curr]) {
            return false;
        }
        if ((prev + curr) % 2 == 1) { // Knight move or adjacent vertically or horizontally
            return true;
        }
        if (Math.abs(prev % 3 - curr % 3) == 1 && Math.abs(prev / 3 - curr / 3) == 1) { // Diagonal
            return true;
        }
        return used[(prev + curr) >> 1]; // Middle element is used
    }
}
