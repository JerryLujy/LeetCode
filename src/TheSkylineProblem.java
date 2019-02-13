import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * <h1>218. The Skyline Problem</h1>
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
 * Now suppose you are given the locations and height of all the buildings,
 * write a program to output the skyline formed by these buildings collectively.
 * <p>
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
 * where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height.
 * It is guaranteed that 0 <= Li, Ri <= INT_MAX, 0 < Hi <= INT_MAX, and Ri - Li > 0.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * <p>
 * For instance, the dimensions of all buildings are recorded as: [[2 9 10],[3 7 15],[5 12 12],[15 20 10],[19 24 8]].
 * The output is a list of "key points" in the format of [[x1,y1],[x2, y2],[x3, y3],...] that uniquely defines a skyline.
 * A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends,
 * is merely used to mark the termination of the skyline, and always has zero height.
 * Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 * For instance, the skyline above should be represented as:[[2 10],[3 15],[7 12],[12 0],[15 10],[20 8],[24, 0]].
 * <p>
 * Notes:
 * <p>
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output skyline.
 * For instance, [...[2 3],[4 5],[7 5],[11 5],[12 7]...] is not acceptable;
 * the three lines of height 5 should be merged into one in the final output as such: [...[2 3],[4 5],[12 7],...]
 *
 * @author Jerry
 * @since 1/30/17
 */
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();
        for (int[] building : buildings) {
            points.add(new int[]{building[0], building[2]});
            points.add(new int[]{building[1], -building[2]});
        }
        points.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparing((int[] a) -> a[1], Comparator.reverseOrder()));
        List<int[]> ans = new ArrayList<>();
        TreeMap<Integer, Integer> heights = new TreeMap<>();
        heights.merge(0, 1, Integer::sum);// Base of the skyline is at height = 0
        int prev = 0;
        for (int[] point : points) {
            if (point[1] > 0) {
                heights.merge(point[1], 1, Integer::sum);// Rising edge
            } else {
                heights.merge(-point[1], -1, Integer::sum);// Falling edge
                if (heights.get(-point[1]) == 0) {
                    heights.remove(-point[1]);
                }
            }
            if (heights.lastKey() != prev) {
                ans.add(new int[]{point[0], heights.lastKey()});
                prev = heights.lastKey();
            }
        }
        return ans;
    }
}
