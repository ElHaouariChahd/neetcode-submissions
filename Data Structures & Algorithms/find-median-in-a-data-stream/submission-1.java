

class MedianFinder {

    PriorityQueue<Integer> small; // Max-heap
    PriorityQueue<Integer> large; // Min-heap

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());

        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }

        return ((double) small.peek() + large.peek()) / 2;
    }
}
