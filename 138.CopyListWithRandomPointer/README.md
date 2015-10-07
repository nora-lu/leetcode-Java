* Hashtable solution: O(n) time, O(n) space.

* Solution2: OPTIMAL, O(n) time, O(1) space. But changed the original list, although restored it.

   Step 1: create a new node for each existing node and join them together eg: A->B->C will be A->A'->B->B'->C->C'

   Step2: copy the random links: for each new node n', n'.random = n.random.next

   Step3: detach the list: basically n.next = n.next.next; n'.next = n'.next.next

http://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/

http://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/
