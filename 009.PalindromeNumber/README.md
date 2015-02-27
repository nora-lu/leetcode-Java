要求不用额外space.
什么算Extra space？？extra space usually means O(n) extra space.Extra space would mean if the space can be expressed as a function of the length of the input. For eg. space could be O(n) if we store the n numbers while comparing arrays. In general space complexity is measured relative to the input size.The space complexity of an algorithm depends on the number of local variables used but also their sizes relative to n.
reverse 最自然的思路就是拿到最高位，去和最低位比，然后依次往里推进。
但这个思路有一个前提，就是需要知道该数的位数，否则如何拿到最高位？在不用额外空间的情况下，我们完全无法迅速得知。
负数算palindrome吗？？不算！！
reverse时候用long避免overflow。

更好的解法：不需要reverse整个string，只reverse一半的string，当rev >= x的时候停止。如果是偶数位palindrom，rev与x相等，如果是奇数位palindrome，rev / 10 = x。好处在于，不需要处理overflow。
