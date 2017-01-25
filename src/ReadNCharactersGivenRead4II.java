/**
 * <h1>158. Read N Characters Given Read4 II - Call multiple times</h1>
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * <p>
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * <p>
 * Note: The read function may be called multiple times.
 *
 * @author Jerry
 * @since 1/24/17
 */
public class ReadNCharactersGivenRead4II {
    private int remainSize = 0;
    private char[] remains = new char[3];

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        int numFromRemain = Math.min(n, remainSize);
        System.arraycopy(remains, 0, buf, 0, numFromRemain);
        count += numFromRemain;
        remainSize -= numFromRemain;
        System.arraycopy(remains, numFromRemain, remains, 0, remainSize);

        if (count == n) {
            return n;
        }
        char[] tmp = new char[4];
        while (count < n) {
            int numRead = read4(tmp);
            if (numRead == 0) {
                return count;
            } else if (numRead <= n - count) {
                System.arraycopy(tmp, 0, buf, count, numRead);
                count += numRead;
            } else {
                System.arraycopy(tmp, 0, buf, count, n - count);
                remainSize = numRead - n + count;
                System.arraycopy(tmp, n - count, remains, 0, remainSize);
                return n;
            }
        }
        return count;
    }

    private int read4(char[] buf) {
        return 0;
    }
}
