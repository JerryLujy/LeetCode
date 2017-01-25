import java.util.Arrays;

/**
 * <h1>164. Maximum Gap</h1>
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * <p>
 * Try to solve it in linear time/space. Return 0 if the array contains less than 2 elements.
 * <p>
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 *
 * @author Jerry
 * @since 1/25/17
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int bucketSize = Math.max(1, (max - min) / (nums.length - 1));
        int bucketNum = 1 + (max - min) / bucketSize;
        int[] maxVals = new int[bucketNum];
        int[] minVals = new int[bucketNum];
        Arrays.fill(maxVals, Integer.MIN_VALUE);
        Arrays.fill(minVals, Integer.MAX_VALUE);
        for (int num : nums) {
            int ind = (num - min) / bucketSize;
            maxVals[ind] = Math.max(maxVals[ind], num);
            minVals[ind] = Math.min(minVals[ind], num);
        }
        int lastMax = min;
        int maxGap = 0;
        for (int i = 0; i < bucketNum; i++) {
            if (maxVals[i] == Integer.MIN_VALUE && minVals[i] == Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, minVals[i] - lastMax);
            lastMax = maxVals[i];
        }
        return maxGap;
    }
}
