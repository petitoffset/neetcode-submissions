class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Comparator.reverseOrder());
        right = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        if (left.size() == 0 || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }
        if (left.size() - right.size() > 1) {
            right.offer(left.poll());
            return;
        }
        if (right.size() - left.size() > 1) {
            left.offer(right.poll());
            return;
        } 
    }
    
    public double findMedian() {
        if (left.size() == right.size()) {
            return (1.0 * left.peek() + right.peek()) / 2;
        } 
        if (left.size() > right.size()) return left.peek();
        return right.peek();
        
    }
}
