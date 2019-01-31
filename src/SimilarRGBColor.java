/**
 * <h1>800. Similar RGB Color</h1>
 * In the following, every capital letter represents some hexadecimal digit from 0 to f.
 * The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand. For example, "#15c" is shorthand for the color "#1155cc".
 * Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.
 * Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, it can be represented as some "#XYZ"
 * <p>
 * Example 1:
 * Input: color = "#09f166"
 * Output: "#11ee66"
 * Explanation:
 * The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
 * This is the highest among any shorthand color.
 * <p>
 * Note:
 * color is a string of length 7.
 * color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from 0 to f
 * Any answer which has the same (highest) similarity as the best answer will be accepted.
 * All inputs and outputs should use lowercase letters, and the output is 7 characters.
 *
 * @author Jerry
 * @since 1/30/19
 */
public class SimilarRGBColor {
    public String similarRGB(String color) {
        return "#" + find(color.substring(1, 3)) + find(color.substring(3, 5)) + find(color.substring(5));
    }

    private String find(String c) {
        int num = Integer.parseInt(c, 16);
        num = (num / 0x11 + (num % 0x11 > 8 ? 1 : 0)) * 0x11;
        return String.format("%02x", num);
    }
}
