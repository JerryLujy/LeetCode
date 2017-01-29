import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h1>212. Word Search II</h1>
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 * <p>
 * For example, Given words = ["oath","pea","eat","rain"] and board =
 * <pre>
 * [['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']]
 * </pre>
 * Return ["eat","oath"].
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 *
 * @author Jerry
 * @since 1/28/17
 */
public class WordSearchII {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    private int m = 0, n = 0;

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ans = new HashSet<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<>();
        }
        m = board.length;
        n = board[0].length;

        TrieNode root = buildTrie(words);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findWords(board, root, i, j, ans);
            }
        }
        return new ArrayList<>(ans);
    }

    private void findWords(char[][] board, TrieNode root, int x, int y, Set<String> ans) {
        char ch = board[x][y];
        if (root.children[ch - 'a'] == null) {
            return;
        }
        root = root.children[ch - 'a'];
        if (root.word != null) {
            ans.add(root.word);
        }
        board[x][y] = ' ';
        for (int k = 0; k < 4; k++) {
            int i = x + dx[k];
            int j = y + dy[k];
            if (i >= 0 && i < m && j >= 0 && j < n && board[i][j] != ' ') {
                findWords(board, root, i, j, ans);
            }
        }
        board[x][y] = ch;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                int ind = ch - 'a';
                if (cur.children[ind] == null) {
                    cur.children[ind] = new TrieNode();
                }
                cur = cur.children[ind];
            }
            cur.word = word;
        }
        return root;
    }

    private static class TrieNode {
        String word;
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[26];
        }
    }
}
