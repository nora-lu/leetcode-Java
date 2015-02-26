我的思路：列举row=3,4,5画出图找出规律，将图分成几个block，每个block大小是row*2-2 （除了最后一个）

接下来：
 * 观察可知 zigSize = nRows + nRows – 2
 * 然后因为一共有1～n行 
 * 第一行就只放每个zig的第一个字符 最后一行也只放每个zag的
 * 当中的那些行 (假设为i行) 那么第一个字符就是 每个zig的第i个字符
 * 第二个在ir行的字符 在每个zig第一个字符在String里位置 +zigSize – 2*ir
