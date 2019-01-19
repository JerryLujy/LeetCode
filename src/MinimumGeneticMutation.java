import java.util.*;

/**
 * <h1>433. Minimum Genetic Mutation</h1>
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 * <p>
 * Note:
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 * <p>
 * Example 1: start: "AACCGGTT", end: "AACCGGTA", bank: ["AACCGGTA"], return: 1
 * <p>
 * Example 2: start: "AACCGGTT", end: "AAACGGTA", bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"], return: 2
 * <p>
 * Example 3: start: "AAAAACCC", end: "AACCCCCC", bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"], return: 3
 *
 * @author Jerry
 * @since 1/18/19
 */
public class MinimumGeneticMutation {
    private List<Character> choices = Arrays.asList('A', 'C', 'G', 'T');

    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        int ans = 0;
        Queue<String> q = new ArrayDeque<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int k = 0; k < count; k++) {
                String cur = q.poll();
                if (cur.equals(end)) {
                    return ans;
                }
                StringBuilder sb = new StringBuilder(cur);
                for (int i = 0; i < sb.length(); i++) {
                    char orig = sb.charAt(i);
                    for (char choice : choices) {
                        sb.setCharAt(i, choice);
                        String next = sb.toString();
                        if (set.contains(next)) {
                            set.remove(next);
                            q.offer(next);
                        }
                    }
                    sb.setCharAt(i, orig);
                }
            }
            ans++;
        }
        return -1;
    }
}
