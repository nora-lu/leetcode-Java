我的做法：和102题几乎一样，除了把subList加到list时候不加到最后，而是加到开头。注意LinkedList有addFirst方法，但是本题需要List interface，而List没有addFirst这个方法。List有add(index, element)这个方法，Inserts the specified element at the specified position in this list (optional operation). Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices). 所以即使List现在是空的，add(0, element)是可以的。特别注意这些方法对index参数范围的限制。

Update: Use LinkedList when inserting element to the head.
