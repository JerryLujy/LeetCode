/**
 * <h1>211. Add and Search Word - Data structure design</h1>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word)
 * <p>
 * bool search(word)
 * <p>
 * search(word) can search a literal word or a regular expression string containing only letters a-z or '.'. A '.' means it can represent any one letter.
 *
 * @author Jerry
 * @since 1/28/17
 */
public class AddAndSearchWord {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public AddAndSearchWord() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int ind = c - 'a';
            if (cur.children[ind] == null) {
                cur.children[ind] = new TrieNode();
            }
            cur = cur.children[ind];
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int ind, TrieNode node) {
        if (ind == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(ind);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && search(word, ind + 1, node.children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            return node.children[c - 'a'] != null && search(word, ind + 1, node.children[c - 'a']);
        }
    }

    private static class TrieNode {
        boolean isWord;
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[26];
        }
    }
}
