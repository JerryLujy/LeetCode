import java.util.ArrayList;
import java.util.List;

/**
 * <h1>54. Spiral Matrix</h1>
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * For example, Given the following matrix:
 * <p>
 * [[ 1, 2, 3 ],
 * <p>
 * [ 4, 5, 6 ],
 * <p>
 * [ 7, 8, 9 ]]
 * <p>
 * You should return [1,2,3,6,9,8,7,4,5].
 *
 * @author Jerry
 * @since 8/27/16
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }
        int rowfrom = 0;
        int rowto = matrix.length - 1;
        int colfrom = 0;
        int colto = matrix[0].length - 1;
        while (rowfrom <= rowto && colfrom <= colto) {
            for (int i = colfrom; i <= colto; i++) ans.add(matrix[rowfrom][i]);
            rowfrom++;
            for (int i = rowfrom; i <= rowto; i++) ans.add(matrix[i][colto]);
            colto--;
            for (int i = colto; i >= colfrom && rowfrom <= rowto; i--) ans.add(matrix[rowto][i]);
            rowto--;
            for (int i = rowto; i >= rowfrom && colfrom <= colto; i--) ans.add(matrix[i][colfrom]);
            colfrom++;
        }
        return ans;
    }
}
