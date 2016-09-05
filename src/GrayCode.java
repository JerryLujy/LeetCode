import java.util.ArrayList;
import java.util.List;

/**
 * <h1>89. Gray Code</h1>
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 * <p>
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * @author Jerry
 * @since 9/3/16
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }
        List<Integer> ans = grayCode(n - 1);
        for (int i = (1 << (n - 1)) - 1; i >= 0; i--) {
            ans.add(ans.get(i) + (1 << (n - 1)));
        }
        return ans;
    }
}
