class KthLargest {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int MAX_SIZE = 0;
    public KthLargest(int k, int[] nums) {
        this.MAX_SIZE = k;
        for (int n : nums) {
            this.addAndBalance(n);
        }
    }
    
    public int add(int val) {
        this.addAndBalance(val);
        return this.minHeap.peek();
    }

    private final void addAndBalance(int val) {
        this.minHeap.offer(val);
        if (this.minHeap.size() > this.MAX_SIZE) {
            this.minHeap.poll();
        }
    }
}
