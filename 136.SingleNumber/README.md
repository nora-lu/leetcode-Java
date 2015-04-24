1.用Hashtable

2. Bit Manipulation

C = A ^ B;  //find the XOR of A and B, store in C

http://stackoverflow.com/questions/1991380/what-does-the-operator-do-in-java

This XOR operation works because it's like XORing all the numbers by itself. So if the array is {2,1,4,5,2,4,1} then it will be like we are performing this operation

((2^2)^(1^1)^(4^4)^(5)) => (0^0^0^5) => 5.

When a number XOR 0, the result is still itself.
