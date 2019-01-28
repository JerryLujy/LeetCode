import support.UnionFind;

/**
 * <h1>130. Surrounded Regions</h1>
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * For example,
 * <pre>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * </pre>
 * After running your function, the board should be:
 * <pre>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * </pre>
 *
 * @author Jerry
 * @since 1/20/17
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        // The last element in union find is a dummy node that represents region out of the board
        UnionFind uf = new UnionFind(m * n + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i < m - 1 && j < n - 1 && board[i + 1][j] == 'O') {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    if (i < m - 1 && j < n - 1 && board[i][j + 1] == 'O') {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                        uf.union(i * n + j, m * n);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && uf.find(i * n + j) != uf.find(m * n)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
