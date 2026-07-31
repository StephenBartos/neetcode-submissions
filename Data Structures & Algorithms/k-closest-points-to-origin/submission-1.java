class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Use a max heap so that the top element will be the one that is furthest away.
        // We then want to remove the top element every time the heap is > k.
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distSq(b), distSq(a))
        );
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.toArray(new int[0][0]);
    } 

    public static int distSq(int[] p) {
        /*
        The sqrt((x1 - x2)^2 + (y1 - y2)^2)) can be simplified when (x2, y2) = (0, 0) to
            sqrt(x1^2 + y1^2)
        Since sqrt is monotonic (preserves ordering), we can just omit it and simplify this to
            x1^2 + y1^2
        */
        return p[0] * p[0] + p[1] * p[1];
    }
}
