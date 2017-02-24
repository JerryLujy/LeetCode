import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>321. Create Maximum Number</h1>
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two.
 * The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.
 * <p>
 * Example 1: nums1 = [3, 4, 6, 5], nums2 = [9, 1, 2, 5, 8, 3], k = 5, return [9, 8, 6, 5, 3]
 * <p>
 * Example 2: nums1 = [6, 7], nums2 = [6, 0, 4], k = 5, return [6, 7, 6, 0, 4]
 * <p>
 * Example 3:, nums1 = [3, 9], nums2 = [8, 9], k = 3, return [9, 8, 9]
 *
 * @author Jerry
 * @since 2/23/17
 */
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] max1 = getMax(nums1, i), max2 = getMax(nums2, k - i);
            int[] merged = merge(max1, max2);
            if (compare(merged, 0, ans, 0)) {
                ans = merged;
            }
        }
        return ans;
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length + arr2.length];
        int ind1 = 0, ind2 = 0, ind = 0;
        while (ind1 < arr1.length || ind2 < arr2.length) {
            ans[ind++] = compare(arr1, ind1, arr2, ind2) ? arr1[ind1++] : arr2[ind2++];
        }
        return ans;
    }

    private boolean compare(int[] arr1, int ind1, int[] arr2, int ind2) {
        int i = ind1, j = ind2;
        for (; i < arr1.length && j < arr2.length; i++, j++) {
            if (arr1[i] != arr2[j]) {
                return arr1[i] > arr2[j];
            }
        }
        return i < arr1.length;
    }

    private int[] getMax(int[] arr, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (stack.size() > 0 && stack.peek() < arr[i] && arr.length - i + stack.size() > n) {
                stack.pop();
            }
            if (stack.size() < n) {
                stack.push(arr[i]);
            }
        }
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
