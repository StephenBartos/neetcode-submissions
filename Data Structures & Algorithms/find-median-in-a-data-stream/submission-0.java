class MedianFinder {
    public PriorityQueue<Integer> rightHalf;
    public PriorityQueue<Integer> leftHalf;

    public MedianFinder() {
        this.leftHalf = new PriorityQueue<Integer>(Comparator.reverseOrder()); // Max Heap
        this.rightHalf = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if (leftHalf.isEmpty() || num <= leftHalf.peek()) {
            leftHalf.offer(num);
        } else {
            rightHalf.offer(num);
        }

        if (Math.abs(leftHalf.size() - rightHalf.size()) > 1) {
            // Rebalance
            if (leftHalf.size() < rightHalf.size()) {
                leftHalf.offer(rightHalf.poll());
            } else {
                rightHalf.offer(leftHalf.poll());
            }
        }
    }
    
    public double findMedian() {
        int totalNums = leftHalf.size() + rightHalf.size();
        if (totalNums % 2 != 0) {
            // Odd => middle exists in the larger half
            if (leftHalf.size() > rightHalf.size()) {
                return leftHalf.peek();
            } else {
                return rightHalf.peek();
            }
        } else {
            // Even -> take the mean of the two
            return (double) (leftHalf.peek() + rightHalf.peek()) / 2.0;
        }
    }
}
