class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a, b) -> Long.compare(
                (long) b[0] * b[0] + (long) b[1] * b[1],
                (long) a[0] * a[0] + (long) a[1] * a[1]
            )
        );

        for (int[] point : points) {
            queue.offer(point);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;
    }
}
