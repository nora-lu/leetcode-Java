/* Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2 */

class MedianFinder {
    // max heap on left
    private Queue<Integer> left = new PriorityQueue<>(16, new Comparator<Integer>(){
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });
    // min heap on right
    private Queue<Integer> right = new PriorityQueue<>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (left.size() == 0) { left.offer(num); }
        else {
            if (num < left.peek()) { left.offer(num); }
            else { right.offer(num); }
        }
        // balance two heaps
        int s1 = left.size(), s2 = right.size();
        if (s1 - s2 > 1) { right.offer(left.poll()); }
        else if (s2 - s1 > 1) { left.offer(right.poll()); }
    }

    // Returns the median of current data stream
    public double findMedian() {
        int s1 = left.size(), s2 = right.size();
        if (s1 == 0 && s2 == 0) { return 0.0; }
        else if (s1 == s2) { return (left.peek() + right.peek()) / (double)2; }
        else { return s1 > s2 ? left.peek() : right.peek(); }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
