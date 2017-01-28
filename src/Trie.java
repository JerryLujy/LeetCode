/**
 * <h1>208. Implement Trie (Prefix Tree)</h1>
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 *
 * @author Jerry
 * @since 1/28/17
 */
public class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int ind = ch - 'a';
            if (cur.children[ind] == null) {
                cur.children[ind] = new TrieNode();
            }
            cur = cur.children[ind];
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if ((cur = cur.children[ch - 'a']) == null) {
                return false;
            }
        }
        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            if ((cur = cur.children[ch - 'a']) == null) {
                return false;
            }
        }
        return true;
    }

    private static class TrieNode {
        boolean isWord;
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[26];
        }
    }
}
