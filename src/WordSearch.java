/**
 * <h1>79. Word Search</h1>
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * For example,Given board =
 * <p>
 * [['A','B','C','E'],
 * <p>
 * ['S','F','C','S'],
 * <p>
 * ['A','D','E','E']]
 * <p>
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 * @author Jerry
 * @since 9/1/16
 */
public class WordSearch {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m * n; i++) {
            if (exist(board, word, m, n, i, 0)) {
                return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int m, int n, int boardInd, int wordInd) {
        int row = boardInd / n;
        int col = boardInd % n;
        if (board[row][col] != word.charAt(wordInd)) {
            return false;
        }
        if (wordInd == word.length() - 1) {
            return true;
        }
        board[row][col] = '.';
        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && board[newRow][newCol] != '.' &&
                    exist(board, word, m, n, newRow * n + newCol, wordInd + 1)) {
                return true;
            }
        }
        board[row][col] = word.charAt(wordInd);
        return false;
    }
}
