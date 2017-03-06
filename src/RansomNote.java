/**
 * <h1>383. Ransom Note</h1>
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * Note: You may assume that both strings contain only lowercase letters.
 * <pre>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * </pre>
 *
 * @author Jerry
 * @since 3/6/17
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a']-- == 0) {
                return false;
            }
        }
        return true;
    }
}
