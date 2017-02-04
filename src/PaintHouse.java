import java.util.Arrays;

/**
 * <h1>256. Paint House</h1>
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 * <p>
 * Note: All costs are positive integers.
 *
 * @author Jerry
 * @since 2/4/17
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int[] curCost = Arrays.copyOf(costs[0], 3);
        for (int i = 1; i < costs.length; i++) {
            int red = costs[i][0] + Math.min(curCost[1], curCost[2]);
            int blue = costs[i][1] + Math.min(curCost[0], curCost[2]);
            int green = costs[i][2] + Math.min(curCost[0], curCost[1]);
            curCost[0] = red;
            curCost[1] = blue;
            curCost[2] = green;
        }
        return Math.min(curCost[0], Math.min(curCost[1], curCost[2]));
    }
}
