import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>150. Evaluate Reverse Polish Notation</h1>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Some examples:
 * <p>
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * <p>
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * @author Jerry
 * @since 1/22/17
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> operands = new ArrayDeque<>();
        Operation operation;
        for (String token : tokens) {
            if ((operation = Operation.fromString(token)) != null) {
                int operand2 = operands.pop();
                int operand1 = operands.pop();
                operands.push(operation.apply(operand1, operand2));
            } else {
                operands.push(Integer.parseInt(token));
            }
        }
        return operands.pop();
    }

    private enum Operation {
        PLUS("+") {
            int apply(int a, int b) {
                return a + b;
            }
        },
        MINUS("-") {
            int apply(int a, int b) {
                return a - b;
            }
        },
        TIMES("*") {
            int apply(int a, int b) {
                return a * b;
            }
        },
        DIVIDE("/") {
            int apply(int a, int b) {
                return a / b;
            }
        };

        private static final Map<String, Operation> map;

        static {
            map = new HashMap<>();
            for (Operation op : values()) {
                map.put(op.symbol, op);
            }
        }

        private final String symbol;

        Operation(String s) {
            symbol = s;
        }

        static Operation fromString(String s) {
            return map.get(s);
        }

        abstract int apply(int a, int b);
    }
}
