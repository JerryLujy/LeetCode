import java.util.ArrayList;
import java.util.List;

/**
 * <h1>271. Encode and Decode Strings</h1>
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 * <p>
 * Note:
 * The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
 * Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 * Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 *
 * @author Jerry
 * @since 2/6/17
 */
public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("%").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        int ind = 0;
        while (ind < s.length()) {
            int split = s.indexOf('%', ind);
            int len = Integer.parseInt(s.substring(ind, split));
            ans.add(s.substring(split + 1, split + len + 1));
            ind = split + len + 1;
        }
        return ans;
    }
}
