我的思路：
题目要求很模糊，ask questions like: Any requirements/specifications on input strings? （除了数字其它字符？空格？） If overflow, what to return? How about '-' '+' 

Requirements for atoi:
1. 去掉空格 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
2. 正负符号optional，parse紧随其后最多的一串数字 Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
3. parse一串数字之后忽略其他的字符 The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
4. 第一串出现的非空格如果不能parse成整数，不需要进行转换，输出0 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed. If no valid conversion could be performed, a zero value is returned. 
5. 处理overflow If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
