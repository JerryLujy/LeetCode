import java.util.ArrayList;
import java.util.List;

/**
 * <h1>52. N-Queens II</h1>
 * Follow up for N-Queens problem. Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 * @author Jerry
 * @since 8/27/16
 */
public class NQueensII {
    private int count;

    public int totalNQueens(int n) {
        count = 0;
        List<Integer> board = new ArrayList<>(n);
        placeQueen(board, n);
        return count;
    }

    private void placeQueen(List<Integer> board, int n) {
        if (board.size() == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board.add(i);
            if (valid(board)) {
                placeQueen(board, n);
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
}
