import java.util.ArrayList;
import java.util.List;

/**
 * <h1>229. Majority Element II</h1>
 * Given an integer array of size n, find all elements that appear more than floor(n/3) times.
 * The algorithm should run in linear time and in O(1) space.
 *
 * @author Jerry
 * @since 2/1/17
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int a = 0, b = 0, numA = 0, numB = 0;
        for (int i : nums) {
            if (a == i) {
                numA++;
            } else if (b == i) {
                numB++;
            } else if (numA == 0) {
                a = i;
                numA = 1;
            } else if (numB == 0) {
                b = i;
                numB = 1;
            } else {
                numA--;
                numB--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        numA = numB = 0;
        for (int i : nums) {
            if (a == i) {
                numA++;
            } else if (b == i) {
                numB++;
            }
        }
        if (numA > nums.length / 3) {
            ans.add(a);
        }
        if (numB > nums.length / 3) {
            ans.add(b);
        }
        return ans;
    }
}
