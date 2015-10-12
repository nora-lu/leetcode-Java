/* The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case. */

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        boolean endOfFile = false;
        int readChars = 0;
        while (readChars < n && !endOfFile) {
            int curReadChars = read4(buffer);
            if (curReadChars != 4) { endOfFile = true; }
            int length = Math.min(curReadChars, n - readChars);  // read n chars but file may be longer than n chars
            for (int i = 0; i < length; i++) {
                buf[readChars + i] = buffer[i];
            }
            readChars += length;
        }
        return readChars;
    }
}
