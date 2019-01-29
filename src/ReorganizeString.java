import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>767. Reorganize String</h1>
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 * If possible, output any possible result.  If not possible, return the empty string.
 * <p>
 * Example 1: Input: S = "aab", Output: "aba"
 * <p>
 * Example 2: Input: S = "aaab", Output: ""
 * <p>
 * Note: S will consist of lowercase letters and have length in range [1, 500].
 *
 * @author Jerry
 * @since 1/28/19
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        int[] freq = new int[26];
        for (char c : S.toCharArray()) {
            freq[c - 'a']++;
        }
        Queue<CharCount> pq = new PriorityQueue<>((a, b) ->
                a.count == b.count ? a.c - b.c : b.count - a.count);
        for (int i = 0; i< 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new CharCount((char)(i + 'a'), freq[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            CharCount c1 = pq.poll();
            CharCount c2 = pq.poll();
            sb.append(c1.c);
            sb.append(c2.c);
            if (--c1.count > 0) {
                pq.offer(c1);
            }
            if (--c2.count > 0) {
                pq.offer(c2);
            }
        }
        if (pq.size() > 0) {
            CharCount c = pq.poll();
            if (c.count > 1) {
                return "";
            }
            sb.append(c.c);
        }
        return sb.toString();
    }

    private static class CharCount {
        char c;
        int count;
        CharCount(char _c, int _count) {
            c = _c;
            count = _count;
        }
    }
}
