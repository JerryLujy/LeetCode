/**
 * <h1>4. Median of Two Sorted Arrays</h1>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1: nums1 = [1, 3], nums2 = [2], The median is 2.0
 * <p>
 * Example 2: nums1 = [1, 2], nums2 = [3, 4], The median is (2 + 3)/2 = 2.5
 *
 * @author Jerry
 * @since 3/22/17
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        if (nums2.length == 0) {
            return (double) (nums1[(nums1.length - 1) / 2] + nums1[nums1.length / 2]) / 2.0;
        }
        int l = 0, r = nums2.length * 2;
        while (l <= r) {
            int m2 = (l + r) >>> 1;
            int m1 = nums1.length + nums2.length - m2;
            double l1 = (m1 == 0) ? Integer.MIN_VALUE : nums1[(m1 - 1) / 2];
            double l2 = (m2 == 0) ? Integer.MIN_VALUE : nums2[(m2 - 1) / 2];
            double r1 = (m1 == nums1.length * 2) ? Integer.MAX_VALUE : nums1[m1 / 2];
            double r2 = (m2 == nums2.length * 2) ? Integer.MAX_VALUE : nums2[m2 / 2];
            if (l1 > r2) {
                l = m2 + 1;
            } else if (l2 > r1) {
                r = m2 - 1;
            } else {
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            }
        }
        return -1;
    }
}
