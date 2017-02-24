import java.util.Arrays;

/**
 * <h1>324. Wiggle Sort II</h1>
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * <p>
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * <p>
 * Note: You may assume all input has valid answer.
 *
 * @author Jerry
 * @since 2/24/17
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int mid = (nums.length - 1) / 2;
        kth(nums, 0, nums.length - 1, mid);
        int[] left = Arrays.copyOfRange(nums, 0, mid + 1);
        int[] right = Arrays.copyOfRange(nums, mid + 1, nums.length);
        int lind = left.length - 1, rind = right.length - 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2 == 0 ? left[lind--] : right[rind--];
        }
    }

    private int kth(int[] nums, int lb, int ub, int k) {
        int[] res = partition(nums, lb, ub);
        int start = res[0], end = res[1];
        if (start > k) {
            return kth(nums, lb, start - 1, k);
        } else if (end < k) {
            return kth(nums, end + 1, ub, k);
        } else {
            return nums[k];
        }
    }

    private int[] partition(int[] nums, int lb, int ub) {
        // 3-way partition, Dijkstra's
        int pivot = nums[lb], i = lb;
        while (i <= ub) {
            if (nums[i] == pivot) {
                i++;
            } else if (nums[i] < pivot) {
                swap(nums, i++, lb++);
            } else {
                swap(nums, i, ub--);
            }
        }
        return new int[]{lb, ub};
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
