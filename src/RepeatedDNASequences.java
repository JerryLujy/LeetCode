import java.util.*;

/**
 * <h1>187. Repeated DNA Sequences</h1>
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p>
 * For example, Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 *
 * @author Jerry
 * @since 1/26/17
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> ans = new HashSet<>();
        Set<Integer> hashes = new HashSet<>();
        // Similar to Rabin-carp algorithm;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('T', 1);
        map.put('C', 2);
        map.put('G', 3);
        int mask = ~(3 << 18);// Remove the left most fingerprint
        for (int i = 0, hash = 0; i < s.length(); i++) {
            hash = ((hash & mask) << 2) + map.get(s.charAt(i));
            if (i >= 9 && !hashes.add(hash)) {
                ans.add(s.substring(i - 9, i + 1));
            }
        }
        return new ArrayList<>(ans);
    }
}
