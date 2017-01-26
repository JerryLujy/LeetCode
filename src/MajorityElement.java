/**
 * <h1>169. Majority Element</h1>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * @author Jerry
 * @since 1/25/17
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int ans = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                ans = num;
            }
            count += ans == num ? 1 : -1;
        }
        return ans;
    }
}
