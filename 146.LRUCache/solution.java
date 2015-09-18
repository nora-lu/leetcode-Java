public class LRUCache {
    
  private class DLinkedNode {
    private int key;
    private int value;
    DLinkedNode pre;
    DLinkedNode next;
  }
  
  // Add the new node right after head.
  private void addNode(DLinkedNode node) {
    node.pre = head;
    node.next = head.next;
    head.next.pre = node;
    head.next = node;
  }

  
  // Remove an existing node from the linked list.
  private void removeNode(DLinkedNode node) {
    DLinkedNode pre = node.pre;
    DLinkedNode next = node.next;
    pre.next = next;
    next.pre = pre;
  }

  // Move certain node in between to the head.
  private void moveToHead(DLinkedNode node) {
    this.removeNode(node);
    this.addNode(node);
  }

  // Pop the current tail.
  private DLinkedNode popTail() {
    DLinkedNode res = tail.pre;
    this.removeNode(res);
    return res;
  }

  private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
  private int count;
  private int capacity;
  private DLinkedNode head, tail;  // dummy head and tail

  public LRUCache(int capacity) {
    this.count = 0;
    this.capacity = capacity;

    head = new DLinkedNode();
    head.pre = null;
    tail = new DLinkedNode();
    tail.next = null;
    
    head.next = tail;
    tail.pre = head;
  }

  public int get(int key) {
    DLinkedNode node = cache.get(key);
    if (node == null) { return -1; }
    
    this.moveToHead(node);
    
    return node.value;
  }

  public void set(int key, int value) {
    DLinkedNode node = cache.get(key);
    if (node == null) {
      DLinkedNode newNode = new DLinkedNode();
      newNode.key = key;
      newNode.value = value;
      
      this.cache.put(key, newNode);
      this.addNode(newNode);
      count++;
   
      if (count > capacity) {
        DLinkedNode tail = this.popTail();
        this.cache.remove(tail.key);
        count--;
      }
    } else {
      node.value = value;
      this.moveToHead(node);
    } 
  }
}
