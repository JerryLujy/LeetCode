import java.util.ArrayList;
import java.util.List;

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
        int bucketGap = 1 + (max - min) / nums.length;
        int numBuckets = 1 + (max - min) / bucketGap;
        List<List<Integer>> buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int num : nums) {
            List<Integer> bucket = buckets.get((num - min) / bucketGap);
            if (bucket.isEmpty()) {
                bucket.add(num); // Min
                bucket.add(num); // Max
            } else {
                if (num < bucket.get(0)) {
                    bucket.set(0, num);
                }
                if (num > bucket.get(1)) {
                    bucket.set(1, num);
                }
            }
        }
        int ans = 0, prevBucket = 0;
        for (int i = 1; i < numBuckets; i++) {
            if (buckets.get(i).isEmpty()) {
                continue;
            }
            ans = Math.max(ans, buckets.get(i).get(0) - buckets.get(prevBucket).get(1));
            prevBucket = i;
        }
        return ans;
    }
}
