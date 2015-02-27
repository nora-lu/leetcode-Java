单链表remove从结尾数起第N个节点，one pass解决。

快慢指针。

Trick的地方：处理要remove的是head的情况。1->2->3 n=3，fast从head开始移动n步，如果为null，说明需要remove head，这时候直接返回head.next

避免处理null的话，用dummyHead，这样fast从dummy开始移动n步之后不会为null（注意题目已经假设n是valid，如果没有这个条件，需要问）

