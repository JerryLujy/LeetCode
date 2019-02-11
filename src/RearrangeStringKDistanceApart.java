import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>358. Rearrange String k Distance Apart</h1>
 * Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
 * <p>
 * All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
 * <p>
 * Example 1: s = "aabbcc", k = 3. Result: "abcabc". The same letters are at least distance 3 from each other.
 * <p>
 * Example 2: s = "aaabc", k = 3. Answer: "". It is not possible to rearrange the string.
 * <p>
 * Example 3: s = "aaadbbcc", k = 2. Answer: "abacabcd". Another possible answer is: "abcabcda". The same letters are at least distance 2 from each other.
 *
 * @author Jerry
 * @since 2/28/17
 */
public class RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        if (k <= 1) {
            return s;
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[1]).reversed().thenComparing((int[] a) -> a[0]));
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.offer(new int[]{i, count[i]});
            }
        }
        Queue<int[]> coolDowns = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (coolDowns.size() == k) {
                pq.offer(coolDowns.poll());
            }
            if (pq.isEmpty()) {
                return "";
            }
            int[] cur = pq.poll();
            if (cur[1] == 0) {
                return "";
            }
            sb.append((char) ('a' + cur[0]));
            cur[1]--;
            coolDowns.offer(cur);
        }
        return sb.toString();
    }
}
