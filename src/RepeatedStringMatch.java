/**
 * <h1>686. Repeated String Match</h1>
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
 * <p>
 * For example, with A = "abcd" and B = "cdabcdab".
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 * <p>
 * Note: The length of A and B will be between 1 and 10000.
 *
 * @author Jerry
 * @since 1/25/19
 */
public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int ans = 1;
        StringBuilder s = new StringBuilder(A);
        while (s.length() < B.length()) {
            s.append(A);
            ans++;
        }
        if (s.indexOf(B) > -1) {
            return ans;
        }
        if (s.append(A).indexOf(B) > -1) {
            return ans + 1;
        }
        return -1;
    }
}
