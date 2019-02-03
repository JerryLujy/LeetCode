import java.util.Random;

/**
 * <h1>497. Random Point in Non-overlapping Rectangles</h1>
 * Given a list of non-overlapping axis-aligned rectangles rects,
 * write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.
 * <p>
 * Note:
 * 1. An integer point is a point that has integer coordinates.
 * 2. A point on the perimeter of a rectangle is included in the space covered by the rectangles.
 * 3. ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
 * 4. length and width of each rectangle does not exceed 2000.
 * 5. 1 <= rects.length <= 100
 * 6. pick return a point as an array of integer coordinates [p_x, p_y]
 * 7. pick is called at most 10000 times.
 * <p>
 * Example 1:
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[[[1,1,5,5]]],[],[],[]]
 * Output:
 * [null,[4,1],[4,1],[3,3]]
 * <p>
 * Example 2:
 * Input:
 * ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
 * Output:
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
 *
 * @author Jerry
 * @since 2/2/19
 */
public class RandomPointInNonOverlappingRectangles {
    int sum;
    int[] pSum;
    int[][] rects;
    Random random;

    public RandomPointInNonOverlappingRectangles(int[][] rects) {
        this.rects = rects;
        random = new Random();
        sum = 0;
        pSum = new int[rects.length];
        for (int i = 0; i < rects.length; i++) {
            sum += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            pSum[i] = sum;
        }
    }

    public int[] pick() {
        int rand = random.nextInt(sum) + 1;
        int l = 0, r = pSum.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (pSum[m] >= rand) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        int[] rect = rects[l];
        int width = rect[2] - rect[0] + 1;
        return new int[]{rect[2] - (pSum[l] - rand) % width, rect[3] - (pSum[l] - rand) / width};
    }
}
