import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * <h1>127. Word Ladder</h1>
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time; Each intermediate word must exist in the word list
 * <p>
 * For example, Given: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * <p>
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 * @author Jerry
 * @since 1/19/17
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> toVisit = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        wordList.add(endWord);
        int dist = 1;

        toVisit.offer(beginWord);
        while (!toVisit.isEmpty()) {
            int count = toVisit.size();
            for (int i = 0; i < count; i++) {
                String curr = toVisit.poll();
                if (curr.equals(endWord)) {
                    return dist;
                }
                addNeighbors(curr, toVisit, visited, wordList);
            }
            dist++;
        }
        return 0;
    }

    private void addNeighbors(String curr, Queue<String> toVisit, Set<String> visited, Set<String> wordList) {
        StringBuilder sb = new StringBuilder(curr);
        for (int i = 0; i < sb.length(); i++) {
            char ith = sb.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == ith) {
                    continue;
                }
                sb.setCharAt(i, c);
                String newString = sb.toString();
                if (wordList.contains(newString) && !visited.contains(newString)) {
                    toVisit.offer(newString);
                    visited.add(newString);
                }
            }
            sb.setCharAt(i, ith);
        }
    }
}
