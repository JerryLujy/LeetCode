/**
 * <h1>88. Merge Sorted Array</h1>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 * @author Jerry
 * @since 9/3/16
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1copy = new int[m];
        System.arraycopy(nums1, 0, nums1copy, 0, m);
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while (i1 < m && i2 < n) {
            if (nums1copy[i1] <= nums2[i2]) {
                nums1[i++] = nums1copy[i1++];
            } else {
                nums1[i++] = nums2[i2++];
            }
        }
        while (i1 < m) {
            nums1[i++] = nums1copy[i1++];
        }
        while (i2 < n) {
            nums1[i++] = nums2[i2++];
        }
    }
}
