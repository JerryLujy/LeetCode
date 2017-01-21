import java.util.Arrays;

/**
 * <h1>135. Candy</h1>
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * <p>
 * What is the minimum candies you must give?
 *
 * @author Jerry
 * @since 1/20/17
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }
        }
        int sum = 0;
        for (int num : candies) {
            sum += num;
        }
        return sum;
    }
}
