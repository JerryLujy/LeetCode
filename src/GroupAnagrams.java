import java.util.*;

/**
 * <h1>49. Group Anagrams</h1>
 * Given an array of strings, group anagrams together. For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return: [["ate", "eat","tea"],["nat","tan"],["bat"]]
 *
 * @author Jerry
 * @since 8/27/16
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> anagramInd = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String anagram = String.valueOf(chars);
            // Can't use char[] as map key, because equals() method of array checks if two arrays are the same object
            if (!anagramInd.containsKey(anagram)) {
                anagramInd.put(anagram, ans.size());
                ans.add(new ArrayList<>());
            }
            ans.get(anagramInd.get(anagram)).add(s);
        }
        return ans;
    }
}
