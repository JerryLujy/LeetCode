/**
 * <h1>294. Flip Game II</h1>
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * <p>
 * Write a function to determine if the starting player can guarantee a win.
 * <p>
 * For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 * <p>
 * Follow up: Derive your algorithm's runtime complexity --> O(n!!)
 *
 * @author Jerry
 * @since 2/11/17
 */
public class FlipGameII {
    public boolean canWin(String s) {
        StringBuilder sb = new StringBuilder(s);
        return canWin(sb);
    }

    private boolean canWin(StringBuilder sb) {
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '+' && sb.charAt(i + 1) == '+') {
                sb.replace(i, i + 2, "--");
                boolean win = !canWin(sb);
                sb.replace(i, i + 2, "++");
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }
}
