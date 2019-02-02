/**
 * <h1>849. Maximize Distance to Closest Person</h1>
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 * There is at least one empty seat, and at least one person sitting.
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 * Return that maximum distance to closest person.
 * <p>
 * Example 1: Input: [1,0,0,0,1,0,1], Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * <p>
 * Example 2: Input: [1,0,0,0], Output: 3
 * Explanation:
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 * <p>
 * Note:
 * 1 <= seats.length <= 20000
 * seats contains only 0s or 1s, at least one 0, and at least one 1.
 *
 * @author Jerry
 * @since 2/1/19
 */
public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int ans = 0;
        int i = -1;
        while (i < seats.length) {
            int j = i + 1;
            while (j < seats.length && seats[j] == 0) {
                j++;
            }
            if (j == seats.length) {
                ans = Math.max(ans, j - i - 1);
            } else if (i == -1){
                ans = Math.max(ans, j);
            } else {
                ans = Math.max(ans, (j - i) / 2);
            }
            i = j;
        }
        return ans;
    }
}
