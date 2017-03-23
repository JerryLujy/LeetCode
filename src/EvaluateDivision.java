import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <h1>399. Evaluate Division</h1>
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 * <p>
 * Example:
 * Given a / b = 2.0, b / c = 3.0. queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * <p>
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries,
 * where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 * <p>
 * According to the example above: equations = [ ["a", "b"], ["b", "c"] ], values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * <p>
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 *
 * @author Jerry
 * @since 3/22/17
 */
public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            graph.putIfAbsent(equations[i][0], new HashMap<>());
            graph.putIfAbsent(equations[i][1], new HashMap<>());
            graph.get(equations[i][0]).put(equations[i][1], values[i]);
            graph.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        double[] ans = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (!dfs(queries[i][0], queries[i][1], graph, ans, i, new HashSet<>())) {
                ans[i] = -1;
            }
        }
        return ans;
    }

    private boolean dfs(String start, String end, Map<String, Map<String, Double>> graph, double[] ans, int i, Set<String> visited) {
        if (visited.contains(start) || !graph.containsKey(start)) {
            return false;
        }
        if (start.equals(end)) {
            ans[i] = 1;
            return true;
        }
        visited.add(start);
        for (Map.Entry<String, Double> next : graph.get(start).entrySet()) {
            if (dfs(next.getKey(), end, graph, ans, i, visited)) {
                ans[i] *= next.getValue();
                return true;
            }
        }
        visited.remove(start);
        return false;
    }
}
