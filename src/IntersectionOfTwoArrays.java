import java.util.HashSet;
import java.util.Set;

/**
 * <h1>349. Intersection of Two Arrays</h1>
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 * @author Jerry
 * @since 2/26/17
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);
        int[] ans = new int[set1.size()];
        int i = 0;
        for (int num : set1) {
            ans[i++] = num;
        }
        return ans;
    }
}
