import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>911. Online Election</h1>
 * In an election, the i-th vote was cast for persons[i] at time times[i].
 * Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.
 * Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.
 * <p>
 * Example 1:
 * Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
 * Output: [null,0,1,1,0,0,1]
 * Explanation:
 * At time 3, the votes are [0], and 0 is leading.
 * At time 12, the votes are [0,1,1], and 1 is leading.
 * At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
 * This continues for 3 more queries at time 15, 24, and 8.
 * <p>
 * Note:
 * 1 <= persons.length = times.length <= 5000
 * 0 <= persons[i] <= persons.length
 * times is a strictly increasing array with all elements in [0, 10^9].
 * TopVotedCandidate.q is called at most 10000 times per test case.
 * TopVotedCandidate.q(int t) is always called with t >= times[0].
 *
 * @author Jerry
 * @since 2/3/19
 */
public class OnlineElection {
    List<int[]> leaders; // {person, time}

    public OnlineElection(int[] persons, int[] times) {
        leaders = new ArrayList<>();
        Map<Integer, Integer> counts = new HashMap<>();
        int leader = -1;
        for (int i = 0; i < persons.length; i++) {
            counts.merge(persons[i], 1, Integer::sum);
            if (leader == -1 || counts.get(persons[i]) >= counts.get(leader) && persons[i] != leader) {
                leader = persons[i];
                leaders.add(new int[]{persons[i], times[i]});
            }
        }
    }

    public int q(int t) {
        int l = 0, r = leaders.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (leaders.get(m)[1] == t) {
                l = m;
                break;
            } else if (leaders.get(m)[1] > t) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (l == 0 || l < leaders.size() && leaders.get(l)[1] == t) {
            return leaders.get(l)[0];
        } else {
            return leaders.get(l - 1)[0];
        }
    }
}
