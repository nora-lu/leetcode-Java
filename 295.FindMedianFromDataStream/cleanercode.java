class MedianFinder {
    // numbers smaller than median, use max heap
    Queue<Long> small = new PriorityQueue<>(Collections.reverseOrder());
    // numbers larger than median, use min heap
    Queue<Long> large = new PriorityQueue<>();
    
    // Adds a number into the data structure.
    public void addNum(int num) {
      // keep small_size >= large_size    
      small.offer((long)num);
      large.offer(small.poll());
      if (small.size() < large.size()) { small.offer(large.poll()); }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return small.size() == large.size() ? (small.peek() + large.peek()) / 2.0 : small.peek();
    } 
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
