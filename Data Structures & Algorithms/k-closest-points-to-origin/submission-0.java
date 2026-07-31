class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Use a max heap so that the top element will be the furthest away.
        // We then want to remove the top element every time the heap is > k.
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(distance(b), distance(a))
        );
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.toArray(new int[0][0]);
    } 

    public static double distance(int[] point) {
        return Math.sqrt(Math.pow(point[0] - 0, 2) + Math.pow(point[1] - 0, 2));
    }
}
