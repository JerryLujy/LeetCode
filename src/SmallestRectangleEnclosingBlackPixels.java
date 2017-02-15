/**
 * <h1>302. Smallest Rectangle Enclosing Black Pixels</h1>
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
 * The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically.
 * Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 * <p>
 * For example, given the following image:
 * <pre>
 * ["0010",
 * "0110",
 * "0100"]
 * </pre>
 * and x = 0, y = 2, Return 6.
 *
 * @author Jerry
 * @since 2/14/17
 */
public class SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        int left = binarySearchCol(image, 0, y, true);
        int right = binarySearchCol(image, y, image[0].length, false);
        int top = binarySearchRow(image, 0, x, true);
        int bottom = binarySearchRow(image, x, image.length, false);
        return (right - left) * (bottom - top);
    }

    private int binarySearchCol(char[][] image, int i, int j, boolean whiteToBlack) {
        while (i < j) {
            int m = (i + j) >>> 1;
            boolean hasBlack = false;
            for (int k = 0; k < image.length; k++) {
                if (image[k][m] == '1') {
                    hasBlack = true;
                    break;
                }
            }
            if (hasBlack == whiteToBlack) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    private int binarySearchRow(char[][] image, int i, int j, boolean whiteToBlack) {
        while (i < j) {
            int m = (i + j) >>> 1;
            boolean hasBlack = false;
            for (int k = 0; k < image[0].length; k++) {
                if (image[m][k] == '1') {
                    hasBlack = true;
                    break;
                }
            }
            if (hasBlack == whiteToBlack) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}
