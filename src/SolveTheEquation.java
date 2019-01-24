/**
 * <h1>640. Solve the Equation</h1>
 * Solve a given equation and return the value of x in the form of string "x=#value".
 * The equation contains only '+', '-' operation, the variable x and its coefficient.
 * If there is no solution for the equation, return "No solution".
 * If there are infinite solutions for the equation, return "Infinite solutions".
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 * <p>
 * Example 1: Input: "x+5-3+x=6+x-2" Output: "x=2"
 * <p>
 * Example 2: Input: "x=x" Output: "Infinite solutions"
 * <p>
 * Example 3: Input: "2x=x" Output: "x=0"
 * <p>
 * Example 4: Input: "2x+3x-6x=x+2" Output: "x=-1"
 * <p>
 * Example 5: Input: "x=x+2" Output: "No solution"
 *
 * @author Jerry
 * @since 1/23/19
 */
public class SolveTheEquation {
    private String coeff(String x) {
        if (x.length() > 1 && Character.isDigit(x.charAt(x.length() - 2))) {
            return x.replace("x", "");
        }
        return x.replace("x", "1");
    }
    public String solveEquation(String equation) {
        int lhs = 0, rhs = 0;
        String[] lr = equation.split("=");
        for (String x: lr[0].split("(?=\\+)|(?=-)")) {
            if (x.indexOf('x') >= 0) {
                lhs += Integer.parseInt(coeff(x));
            } else {
                rhs -= Integer.parseInt(x);
            }
        }
        for (String x: lr[1].split("(?=\\+)|(?=-)")) {
            if (x.indexOf('x') >= 0) {
                lhs -= Integer.parseInt(coeff(x));
            } else {
                rhs += Integer.parseInt(x);
            }
        }
        if (lhs != 0) {
            return "x=" + rhs / lhs;
        } else if (rhs == 0) {
            return "Infinite solutions";
        } else {
            return "No solution";
        }
    }
}
