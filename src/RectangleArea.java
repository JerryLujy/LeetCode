import java.util.Arrays;

/**
 * <h1>223. Rectangle Area</h1>
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner.
 * [[A,B][C,D]] for the first rectangle, and [[E,F],[G,H]] for the second.
 * <p>
 * Assume that the total area is never beyond the maximum possible value of int.
 *
 * @author Jerry
 * @since 1/31/17
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        boolean vertOverlap = A < G && E < C;
        boolean horiOverlap = B < H && F < D;
        int total = (C - A) * (D - B) + (G - E) * (H - F);
        if (vertOverlap && horiOverlap) {
            int[] xs = new int[]{A, C, E, G};
            int[] ys = new int[]{B, D, F, H};
            Arrays.sort(xs);
            Arrays.sort(ys);
            return total - (xs[2] - xs[1]) * (ys[2] - ys[1]);
        }
        return total;
    }
}
