关键搞清楚两点：

每位逢9进1.
9999这种情况，加1后，变成0000，要防止溢出，在最前面加一位，并赋值为1.

java处理999...+ 1的情况，新建一个array。这里注意，默认array里都是0，所以直接将第一个赋值1即可。