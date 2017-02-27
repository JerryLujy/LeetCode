/**
 * <h1>348. Design Tic-Tac-Toe</h1>
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * <p>
 * You may assume the following rules:
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 *
 * @author Jerry
 * @since 2/26/17
 */
public class DesignTicTacToe {
    private int n;
    private int[] rows, cols;
    private int diag1, diag2;

    /**
     * Initialize your data structure here.
     */
    public DesignTicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        diag1 = diag2 = 0;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) {
            diag1 += toAdd;
        }
        if (row + col == n - 1) {
            diag2 += toAdd;
        }
        return (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n ||
                Math.abs(diag1) == n || Math.abs(diag2) == n) ? player : 0;
    }
}
