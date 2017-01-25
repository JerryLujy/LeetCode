/**
 * <h1>157. Read N Characters Given Read4</h1>
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * <p>
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * <p>
 * Note: The read function will only be called once for each test case.
 *
 * @author Jerry
 * @since 1/24/17
 */
public class ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        int count = 0;
        while (count < n) {
            int nread = Math.min(read4(tmp), n - count);
            if (nread == 0) {
                return count;
            }
            System.arraycopy(tmp, 0, buf, count, nread);
            count += nread;
        }
        return count;
    }

    private int read4(char[] buf) {
        return 0;
    }
}
