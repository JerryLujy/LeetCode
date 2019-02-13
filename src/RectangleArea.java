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
        int l = Math.max(A, E), r = Math.min(C, G);
        int b = Math.max(B, F), t = Math.min(D, H);
        int overlap = 0;
        if (l < r && b < t) {
            overlap =  (r - l) * (t - b);
        }
        return (C - A) * (D - B) + (G - E) * (H - F) - overlap;
    }
}
