/**
 * <h1>375. Guess Number Higher or Lower II</h1>
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * <p>
 * However, when you guess a particular number x, and you guess wrong, you pay $x.
 * You win the game when you guess the number I picked.
 * <p>
 * Example: n = 10, I pick 8.
 * <p>
 * First round:  You guess 5, I tell you that it's higher. You pay $5.
 * Second round: You guess 7, I tell you that it's higher. You pay $7.
 * Third round:  You guess 9, I tell you that it's lower. You pay $9.
 * <p>
 * Game over. 8 is the number I picked. You end up paying $5 + $7 + $9 = $21.
 * <p>
 * Given a particular n >= 1, find out how much money you need to have to guarantee a win.
 *
 * @author Jerry
 * @since 3/6/17
 */
public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        int[][] mem = new int[n + 1][n + 1];
        return getMoneyAmount(1, n, mem);
    }

    private int getMoneyAmount(int i, int j, int[][] mem) {
        if (i >= j) {
            return 0;
        }
        if (mem[i][j] > 0) {
            return mem[i][j];
        }
        int minAmount = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            minAmount = Math.min(minAmount, Math.max(getMoneyAmount(i, k - 1, mem), getMoneyAmount(k + 1, j, mem)) + k);
        }
        return mem[i][j] = minAmount;
    }
}
