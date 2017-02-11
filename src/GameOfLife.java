/**
 * <h1>289. Game of Life</h1>
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * <p>
 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 *
 * @author Jerry
 * @since 2/11/17
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] |= nextState(board, i, j) << 1; // Next state stored in second bit
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int nextState(int[][] board, int x, int y) {
        int count = 0;
        for (int i = Math.max(0, x - 1); i <= Math.min(board.length - 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(board[0].length - 1, y + 1); j++) {
                if (i != x || j != y) {
                    count += board[i][j] & 1;
                }
            }
        }
        if (board[x][y] == 1 && (count < 2 || count > 3)) {
            return 0;
        }
        if (board[x][y] == 0 && count == 3) {
            return 1;
        }
        return board[x][y];
    }
}
