import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1>356. Line Reflection</h1>
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
 * <p>
 * Example 1: Given points = [[1,1],[-1,1]], return true.
 * <p>
 * Example 2: Given points = [[1,1],[-1,-1]], return false.
 *
 * @author Jerry
 * @since 2/28/17
 */
public class LineReflection {
    public boolean isReflected(int[][] points) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] point : points) {
            min = Math.min(min, point[0]);
            max = Math.max(max, point[0]);
            set.add(Arrays.hashCode(point));
        }
        for (int[] point : points) {
            if (!set.contains(Arrays.hashCode(new int[]{max + min - point[0], point[1]}))) {
                return false;
            }
        }
        return true;
    }
}
