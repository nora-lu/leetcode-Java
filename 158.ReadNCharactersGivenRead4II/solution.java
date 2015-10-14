/* The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times. */

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    private char[] buffer = new char[4];
    private int buffPtr = 0;  // next available char not stored in buf yet, but already read from last call to read4
    private int buffCtr = 0;  // number of char read from last read4
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buffPtr == 0) {  // available to read new data 
                buffCtr = read4(buffer);
            }
            if (buffCtr == 0) { break; }  // end of file
            while (ptr < n && buffPtr < buffCtr) {
                buf[ptr++] = buffer[buffPtr++];
            }
            if (buffPtr >= buffCtr) { buffPtr = 0; }
        }
        return ptr;
    }
}
