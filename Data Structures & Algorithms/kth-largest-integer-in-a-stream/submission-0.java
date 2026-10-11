class KthLargest {
    int k = 0;
    int[] nums = new int[0];
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        this.queue.offer(val);

        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
