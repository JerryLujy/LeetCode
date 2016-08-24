/**
 * <h1>38. Count and Say</h1>
 * The count-and-say sequence is the sequence of integers beginning as follows: 1, 11, 21, 1211, 111221, ...
 * <p>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * @author Jerry
 * @since 8/24/16
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = countAndSay(n - 1);

        StringBuilder sb = new StringBuilder();
        char cur = s.charAt(0);
        int count = 1;

        for (int ind = 1; ind < s.length(); ind++) {
            if (s.charAt(ind) != cur) {
                sb.append(count).append(cur);
                cur = s.charAt(ind);
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count).append(cur);
        return sb.toString();
    }
}
