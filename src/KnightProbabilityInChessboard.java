/**
 * <h1>688. Knight Probability in Chessboard</h1>
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves.T
 * he rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
 * A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
 * The knight continues moving until it has made exactly K moves or has moved off the chessboard.
 * Return the probability that the knight remains on the board after it has stopped moving.
 * <p>
 * Example: Input: 3, 2, 0, 0. Output: 0.0625
 * Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
 * From each of those positions, there are also two moves that will keep the knight on the board.
 * The total probability the knight stays on the board is 0.0625.
 * <p>
 * Note:
 * N will be between 1 and 25.
 * K will be between 0 and 100.
 * The knight always initially starts on the board.
 *
 * @author Jerry
 * @since 1/25/19
 */
public class KnightProbabilityInChessboard {
    int[] dx = {1, 2, 2, 1, -1, -2, -2, -1}, dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public double knightProbability(int N, int K, int r, int c) {
        // prob[x][y][k] = probability to remain on board on (x, y) with k remaining steps
        double[][][] prob = new double[N][N][K + 1];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                prob[x][y][0] = 1.0;
            }
        }
        for (int k = 1; k <= K; k++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    for (int i = 0; i < 8; i++) {
                        int xx = x + dx[i], yy = y + dy[i];
                        if (xx >= 0 && xx < N && yy >= 0 && yy < N) {
                            prob[x][y][k] += prob[xx][yy][k - 1] / 8;
                        }
                    }
                }
            }
        }
        return prob[r][c][K];
    }
}
