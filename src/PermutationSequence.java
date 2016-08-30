/**
 * <h1>60. Permutation Sequence</h1>
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * <p>
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 *
 * @author Jerry
 * @since 8/29/16
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] selected = new boolean[n + 1];

        int totalChoice = 1;
        for (int i = 2; i <= n - 1; i++) {
            totalChoice *= i;
        }

        for (int i = n - 1; i >= 1; i--) {
            int choice = (k - 1) / totalChoice + 1;
            int curNum = kth(selected, n, choice);
            sb.append(curNum);
            k -= (choice - 1) * totalChoice;
            totalChoice /= i;
        }
        sb.append(kth(selected, n, 1));
        return sb.toString();
    }

    private int kth(boolean[] selected, int n, int k) {
        int i = 1;
        for (; i <= n; i++) {
            if (!selected[i] && --k == 0) {
                break;
            }
        }
        selected[i] = true;
        return i;
    }
}
