import java.util.*;

/**
 * <h1>126. Word Ladder II</h1>
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time; Each intermediate word must exist in the word list
 * <p>
 * For example, Given: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"], Return
 * [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * <p>
 * Note: All words have the same length. All words contain only lowercase alphabetic characters.
 *
 * @author Jerry
 * @since 1/19/17
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Map<String, List<String>> neighbors = new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();
        wordList.add(endWord);
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();

        bfs(beginWord, endWord, wordList, neighbors, distances);
        if (distances.containsKey(endWord)) {// Find path only if end word is reachable
            dfs(beginWord, endWord, neighbors, distances, ans, path);
        }
        return ans;
    }

    private void bfs(String beginWord, String endWord, Set<String> wordList, Map<String, List<String>> neighbors, Map<String, Integer> distances) {
        distances.put(beginWord, 0);
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        boolean shouldEnd = false;
        while (!queue.isEmpty() && !shouldEnd) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                String curr = queue.poll();
                int currDistance = distances.get(curr);
                neighbors.put(curr, getNeighbors(curr, wordList));
                for (String s : neighbors.get(curr)) {
                    if (!distances.containsKey(s)) {// First time visiting this node
                        distances.put(s, currDistance + 1);
                        queue.offer(s);
                        shouldEnd = s.equals(endWord);
                    }
                }
            }
        }
    }

    private void dfs(String curr, String end, Map<String, List<String>> neighbors, Map<String, Integer> distances, List<List<String>> ans, List<String> path) {
        path.add(curr);
        int currDistance = distances.get(curr);
        if (curr.equals(end)) {
            ans.add(new ArrayList<>(path));
        } else if (currDistance != distances.get(end)) {
            for (String next : neighbors.get(curr)) {
                if (distances.get(next) == currDistance + 1) {
                    dfs(next, end, neighbors, distances, ans, path);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    private List<String> getNeighbors(String curr, Set<String> wordList) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(curr);
        for (int i = 0; i < curr.length(); i++) {
            char ith = sb.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                sb.setCharAt(i, c);
                String newString = sb.toString();
                if (c != ith && wordList.contains(newString)) {
                    ans.add(newString);
                }
            }
            sb.setCharAt(i, ith);
        }
        return ans;
    }
}
