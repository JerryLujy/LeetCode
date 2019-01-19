import java.util.*;

/**
 * <h1>444. Sequence Reconstruction</h1>
 * Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs.
 * The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 10^4.
 * Reconstruction means building a shortest common supersequence of the sequences in seqs
 * (i.e., a shortest sequence so that all sequences in seqs are subsequences of it).
 * Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.
 *
 * Example 1: Input: org: [1,2,3], seqs: [[1,2],[1,3]], Output: false
 * Explanation: [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.
 *
 * Example 2: Input: org: [1,2,3], seqs: [[1,2]], Output: false
 * Explanation: The reconstructed sequence can only be [1,2].
 *
 * Example 3: Input: org: [1,2,3], seqs: [[1,2],[1,3],[2,3]], Output: true
 * Explanation: The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
 *
 * Example 4: Input: org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]], Output: true
 *
 * @author Jerry
 * @since 1/18/19
 */
public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (List<Integer> seq : seqs) {
            if (seq.size() == 1 && !map.containsKey(seq.get(0))) {
                map.put(seq.get(0), new HashSet<>());
                indegree.put(seq.get(0), 0);
                continue;
            }
            for (int i = 1; i < seq.size(); i++) {
                if (!map.containsKey(seq.get(i - 1))) {
                    map.put(seq.get(i - 1), new HashSet<>());
                    indegree.put(seq.get(i - 1), 0);
                }
                if (!map.containsKey(seq.get(i))) {
                    map.put(seq.get(i), new HashSet<>());
                    indegree.put(seq.get(i), 0);
                }
                if (map.get(seq.get(i - 1)).add(seq.get(i))) {
                    indegree.merge(seq.get(i), 1, Integer::sum);
                }
            }
        }
        if (org.length != map.size()) {
            return false;
        }
        int curInd = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i : indegree.keySet()) {
            if (indegree.get(i) == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty() && curInd < org.length) {
            if (q.size() > 1) {
                return false;
            }
            int cur = q.poll();
            if (cur != org[curInd++]) {
                return false;
            }
            for (int next : map.get(cur)) {
                if (indegree.merge(next, -1, Integer::sum) == 0) {
                    q.offer(next);
                }
            }
        }
        return curInd == org.length;
    }
}
