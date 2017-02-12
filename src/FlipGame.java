import java.util.ArrayList;
import java.util.List;

/**
 * <h1>293. Flip Game</h1>
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * <p>
 * Write a function to compute all possible states of the string after one valid move.
 * <p>
 * For example, given s = "++++", after one move, it may become one of the following states: ["--++","+--+","++--"]
 * <p>
 * If there is no valid move, return an empty list [].
 *
 * @author Jerry
 * @since 2/11/17
 */
public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length() - 1; i++) {
            if (sb.charAt(i) == '+' && sb.charAt(i + 1) == '+') {
                sb.replace(i, i + 2, "--");
                ans.add(sb.toString());
                sb.replace(i, i + 2, "++");
            }
        }
        return ans;
    }
}
