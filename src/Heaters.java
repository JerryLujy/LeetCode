import java.util.Arrays;

/**
 * <h1>475. Heaters</h1>
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
 * <p>
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 * <p>
 * Example 1: Input: [1,2,3],[2], Output: 1, Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 * <p>
 * Example 2: Input: [1,2,3,4],[1,4], Output: 1, Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 *
 * @author Jerry
 * @since 1/19/19
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = 0;
        for (int house : houses) {
            int result = Arrays.binarySearch(heaters, house);
            if (result < 0) {
                int insertPos = -(result + 1), tempAns = Integer.MAX_VALUE;
                if (insertPos > 0) {
                    tempAns = Math.min(tempAns, house - heaters[insertPos - 1]);
                }
                if (insertPos < heaters.length) {
                    tempAns = Math.min(tempAns, heaters[insertPos] - house);
                }
                ans = Math.max(ans, tempAns);
            }
        }
        return ans;
    }
}
