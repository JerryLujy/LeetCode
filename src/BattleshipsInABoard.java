/**
 * <h1>419. Battleships in a Board</h1>
 * Given an 2D board, count how many battleships are in it.
 * The battleships are represented with 'X's, empty slots are represented with '.'s.
 * <p>
 * You may assume the following rules:
 * 1. You receive a valid board, made of only battleships or empty slots.
 * 2. Battleships can only be placed horizontally or vertically.
 * In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * 3. At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * <p>
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * <p>
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 *
 * @author Jerry
 * @since 1/15/19
 */
public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        int count = 0;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }
                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                count++;
            }
        }
        return count;
    }
}
