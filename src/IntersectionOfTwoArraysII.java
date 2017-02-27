import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>350. Intersection of Two Arrays II</h1>
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * <p>
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 * @author Jerry
 * @since 2/26/17
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> inter = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                inter.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] ans = new int[inter.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = inter.get(i);
        }
        return ans;
    }
}
