/**
 * <h1>393. UTF-8 Validation</h1>
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 * For 1-byte character, the first bit is a 0, followed by its unicode code.
 * For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
 * This is how the UTF-8 encoding would work:
 * <pre>
 * Char. number range  |        UTF-8 octet sequence
 *   (hexadecimal)     |              (binary)
 * --------------------+-------------------------------------
 * 0000 0000-0000 007F | 0xxxxxxx
 * 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 * 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 * 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * </pre>
 * Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
 * <p>
 * Note: The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data.
 * his means each integer represents only 1 byte of data.
 * <p>
 * Example 1: data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001. Return true.
 * <p>
 * Example 2: data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100. Return false.
 *
 * @author Jerry
 * @since 3/13/17
 */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int bytes = 0;
            if ((data[i] & 248) == 240) { // 11110XXX
                bytes = 4;
            } else if ((data[i] & 240) == 224) { // 1110XXXX
                bytes = 3;
            } else if ((data[i] & 224) == 192) { // 110XXXXX
                bytes = 2;
            } else if ((data[i] & 128) == 0) {
                bytes = 1;
            } else {
                return false;
            }
            while (--bytes > 0) {
                i++;
                if (i == data.length || (data[i] & 128) != 128) {
                    return false;
                }
            }
        }
        return true;
    }
}
