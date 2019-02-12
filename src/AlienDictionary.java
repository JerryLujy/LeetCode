import java.util.*;

/**
 * <h1>269. Alien Dictionary</h1>
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 * You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 * <p>
 * For example,Given the following words in dictionary,
 * <p>
 * ["wrt","wrf","er","ett","rftt"]
 * <p>
 * The correct order is: "wertf".
 * <p>
 * Note:
 * You may assume all letters are in lowercase.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 *
 * @author Jerry
 * @since 2/5/17
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.putIfAbsent(c, 0);
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1], curr = words[i];
            for (int j = 0; j < Math.min(prev.length(), curr.length()); j++) {
                if (prev.charAt(j) != curr.charAt(j)) {
                    if (graph.get(prev.charAt(j)).add(curr.charAt(j))) {
                        indegree.merge(curr.charAt(j), 1, Integer::sum);
                    }
                    break;
                }
                if (j == curr.length() - 1 && prev.length() > curr.length()) {
                    return ""; // Deals with "abc" -> "ab"
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new ArrayDeque<>();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            Character curr = queue.poll();
            sb.append(curr);
            for (Character next : graph.get(curr)) {
                if (indegree.merge(next, -1, Integer::sum) == 0) {
                    queue.offer(next);
                }
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}
