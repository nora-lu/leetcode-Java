我的思路：
1. integer parse成string，注意符号

2. 不通过parse，通过整数运算。

没考虑到的问题：
If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100. 如果原数的个位是0, res 则会一直保持是0, 直到非0的出现.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
将 res 设为 long, 那你一个 int 怎么反转都不会超出 long 的范围了吧? 然后判断 res 和 INT_MAX的关系就可以了.

思考：注意处理overflow，运用long类型来防止overflow

如果不用long类型：
To check for overflow/underflow, we could check if ret >
214748364 or ret < –214748364 before multiplying by 1 0. On the other hand, if ret ==
214748364, it must not overflow because the last reversed digit is guaranteed to be 1 due
to constraint of the input x.
