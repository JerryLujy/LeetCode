import java.util.HashSet;

/**
 * <h1>36. Valid Sudoku</h1>
 * Determine if a Sudoku is valid.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 *
 * @author Jerry
 * @since 8/23/16
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set1.clear();
            set2.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !set1.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !set2.add(board[j][i])) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                set1.clear();
                for (int ii = 0; ii < 3; ii++) {
                    for (int jj = 0; jj < 3; jj++) {
                        if (board[i + ii][j + jj] != '.' && !set1.add(board[i + ii][j + jj])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
