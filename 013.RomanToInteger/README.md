重点读了一下什么是Roman numberals. 看完之后，明确以下几点规则：

基本字符表：I V X L C D M (1, 5, 10, 50, 100, 500, 1000)
the numeral I can be placed before V and X to make 4 units (IV) and 9 units (IX) respectively.
X can be placed before L and C to make 40 (XL) and 90 (XC) respectively.
C can be placed before D and M to make 400 (CD) and 900 (CM) according to the same pattern.
由于要累计总数，肯定是逆循环解析字符串，遇到I,X,C要特殊处理，即判断在左还是在右，左要减，右要加。 其余字符，加上其所代表的阿拉伯数字即可。
