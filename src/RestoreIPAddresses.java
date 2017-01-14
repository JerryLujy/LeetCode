import java.util.ArrayList;
import java.util.List;

/**
 * <h1>93. Restore IP Addresses</h1>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * For example: Given "25525511135", return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 * @author Jerry
 * @since 1/13/17
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> ip = new ArrayList<>();
        findIp(ans, ip, s);
        return ans;
    }

    private void findIp(List<String> ans, List<String> ip, String remain) {
        if (ip.size() == 4) {
            if (remain.length() == 0) {
                ans.add(ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + ip.get(3));
            }
            return;
        }
        int maxlen = Math.min(remain.length(), 3);
        for (int i = 1; i <= maxlen; i++) {
            String byteStr = remain.substring(0, i);
            if (isValid(byteStr)) {
                ip.add(byteStr);
                findIp(ans, ip, remain.substring(i));
                ip.remove(ip.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        return num < 256 && num >= 0;
    }
}
