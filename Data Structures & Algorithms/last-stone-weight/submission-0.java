class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            heap.offer(stones[i]);
        }
        while (heap.size() > 1) {
            int stone0 = heap.poll(); // heaviest
            int stone1 = heap.poll(); // 2nd heaviest
            int difference = stone0 - stone1;
            if (difference > 0) {
                heap.offer(difference);
            }
        }
        // Either the last two destroyed each other or there's 1 remaining
        return (heap.isEmpty() ? 0 : heap.poll());
    }
}
