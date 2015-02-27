我的思路：先brutal force，选长度最短的string，比如abc，然后用a，ab，abc一个个去测试是否是其它的prefix。
优化：选strs[0]，比如abc，每个char放进hashmap，{'a':0; 'b':1; 'c':2} 重复的字符不好处理。
用i从0开始，check每个string的i位置上char是否相同，不相同停止。

1) "Horizontal matching (over strings)". Pick up the first string and compare it with the rest. Return the minimum prefix found among all comparisons.

2) "Vertical matching (over characters)". Compare the characters between all strings from left to right. Stop whenever a mismatch is found.

The first one is apparently not very optimal. Imagine only the last string is different from all others. You would have wasted so much time comparing the previous ones. The second one is the optimal solution.
