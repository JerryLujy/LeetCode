import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * <h1>37. Sudoku Solver</h1>
 * Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 *
 * @author Jerry
 * @since 8/24/16
 */
public class SudokuSolver {

    public static void main(String[] args) {
        String boardStr = "..9748...7.........2.1.9.....7...24..64.1.59..98...3.....8.3.2.........6...2759..";
        char[][] board = new char[9][];
        for (int i = 0; i < 9; i++) {
            board[i] = boardStr.substring(9 * i, 9 * i + 9).toCharArray();
        }

        printboard(board);

        SudokuSolver solver = new SudokuSolver();
        ValidSudoku validator = new ValidSudoku();

        solver.solveSudoku(board);
        assert (validator.isValidSudoku(board));

        printboard(board);
    }

    private static void printboard(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : board) {
            for (char c : row) {
                sb.append(c).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    public void solveSudoku(char[][] board) {
        fill(0, board);
    }

    private boolean fill(int pos, char[][] board) {
        if (pos == 81) {
            return true;
        }
        if (board[pos / 9][pos % 9] != '.') {
            return fill(pos + 1, board);
        }
        List<Character> possibilities = possibleChar(pos, board);
        if (possibilities.size() == 0) {
            return false;
        }
        for (char c : possibilities) {
            board[pos / 9][pos % 9] = c;
            if (fill(pos + 1, board)) {
                return true;
            }
            board[pos / 9][pos % 9] = '.';
        }
        return false;
    }

    private List<Character> possibleChar(int pos, char[][] board) {
        List<Character> res = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        int row = pos / 9;
        int col = pos % 9;
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.') {
                set.add(board[row][i]);
            }
            if (board[i][col] != '.') {
                set.add(board[i][col]);
            }
        }
        int cuberow = row / 3;
        int cubecol = col / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[cuberow * 3 + i][cubecol * 3 + j] != '.') {
                    set.add(board[cuberow * 3 + i][cubecol * 3 + j]);
                }
            }
        }
        for (char c = '1'; c <= '9'; c++) {
            if (!set.contains(c)) {
                res.add(c);
            }
        }
        return res;
    }
}
