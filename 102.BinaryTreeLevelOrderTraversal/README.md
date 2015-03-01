我的思路：先想递归，但是左右节点各返回List<List>，如何合并同一个level是个问题，卡住了

看tag：BFS，想到用Queue来做。

问题是如何知道每次deque的节点在哪一个level？我的方法：新建private class NodeWithLevel，每次visit一个节点，explore它的左右child时候，child.level = parent.level + 1。deque节点，先检查这个level在结果的List中存不存在。

注意的地方：1. Java里Queue是Interface，所以不能直接建个Queue。The best option is to construct off a class that already implements the Queue interface, like one of the following: AbstractQueue, ArrayBlockingQueue, ConcurrentLinkedQueue, DelayQueue, LinkedBlockingQueue, LinkedList, PriorityBlockingQueue, PriorityQueue, or SynchronousQueue. 本题用了LinkedList。

Queue<String> qe=new LinkedList<String>();

或者自己写个Queue的class。

2. 正确做法：
List<List> list = new ArrayList<List>(); 然后再继续specifiy内层List的implementation

错误做法：List<List> list1 = new ArrayList<ArrayList>();

参考：http://docs.oracle.com/javase/tutorial/java/generics/inheritance.html

思考：写recursion的解法
