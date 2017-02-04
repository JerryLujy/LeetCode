import java.util.Arrays;

/**
 * <h1>238. Product of Array Except Self</h1>
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 * @author Jerry
 * @since 2/3/17
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int l = -1, r = nums.length;
        int lProd = 1, rProd = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[++l] *= lProd;
            ans[--r] *= rProd;
            lProd *= nums[l];
            rProd *= nums[r];
        }
        return ans;
    }
}
