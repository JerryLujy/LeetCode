import java.util.*;

/**
 * <h1>332. Reconstruct Itinerary</h1>
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
 * All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * <p>
 * Note:
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * <p>
 * Example 1: tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]], Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * <p>
 * Example 2: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]], Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 *
 * @author Jerry
 * @since 2/25/17
 */
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).offer(ticket[1]);
        }
        LinkedList<String> ans = new LinkedList<>();
        dfs(map, ans, "JFK");
        return ans;
    }

    private void dfs(Map<String, Queue<String>> map, LinkedList<String> ans, String cur) {
        while (map.containsKey(cur) && !map.get(cur).isEmpty()) {
            dfs(map, ans, map.get(cur).poll());
        }
        ans.addFirst(cur);
    }
}
