import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <h1>316. Remove Duplicate Letters</h1>
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p>
 * Example: Given "bcabc", Return "abc"
 * <p>
 * Given "cbacdcbc", Return "acdb"
 *
 * @author Jerry
 * @since 2/19/17
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] occurences = new int[26];
        for (char c : s.toCharArray()) {
            occurences[c - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            occurences[c - 'a']--;
            if (stack.contains(c)) { // Already in the result, ignore it
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && occurences[stack.peek() - 'a'] > 0) {
                // Remove stack top if current character is smaller and the removed char can be added later
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
