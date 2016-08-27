import java.util.ArrayList;
import java.util.List;

/**
 * <h1>51. N-Queens</h1>
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * For example, There exist two distinct solutions to the 4-queens puzzle:
 * <p>
 * [
 * [".Q..",
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 *
 * @author Jerry
 * @since 8/27/16
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<Integer> board = new ArrayList<>(n);
        placeQueen(ans, board, n);
        return ans;
    }

    private void placeQueen(List<List<String>> ans, List<Integer> board, int n) {
        if (board.size() == n) {
            ans.add(drawBoard(board));
        }
        for (int i = 0; i < n; i++) {
            board.add(i);
            if (valid(board)) {
                placeQueen(ans, board, n);
            }
            board.remove(board.size() - 1);
        }
    }

    private boolean valid(List<Integer> board) {
        int newRow = board.size() - 1;
        int newCol = board.get(newRow);
        for (int i = 0; i < newRow; i++) {
            if (board.get(i) == newCol || Math.abs(newCol - board.get(i)) == newRow - i) {
                return false;
            }
        }
        return true;
    }

    private List<String> drawBoard(List<Integer> board) {
        List<String> boardStr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.size(); i++) {
            sb.append('.');
        }
        for (int i : board) {
            sb.setCharAt(i, 'Q');
            boardStr.add(sb.toString());
            sb.setCharAt(i, '.');
        }
        return boardStr;
    }
}
